package com.bycoders.cnabdemo.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bycoders.cnabdemo.resource.TransacaoFinanceiraResource;
import com.bycoders.cnabdemo.services.TransacaoFinanceiraService;
import com.bycoders.cnabdemo.utils.ResourceResponseUtil;


/**
 * Controller que recebe as requisições do formulário de upload e 
 * da página de listagem
 * 
 * @author patrik
 *
 */
@Controller
public class HomePageController {

	String serverUrl = "";
	
	HomePageController(@Value("${server.port:8080}") String apiPort) {
		serverUrl = String.format("http://localhost:%s", apiPort); 	
	}

	@Autowired
	TransacaoFinanceiraResource transacaoFinanceiraResource;

	@Autowired
	TransacaoFinanceiraService transacaoFinanceiraService;  
	
    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }
    
    /**
     * Recebe a ação do formulário de upload e chama a API para armazenar
     * processar o arquivo e persistir os dados no banco
     *  
     * @param file
     * @param attributes
     * @return
     * @throws IOException 
     * @throws JSONException 
     */
    @PostMapping("/upload")
    public String uploadFile(Model model, @RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws JSONException {
    	RestTemplate restTemplate = new RestTemplate();
    	
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.MULTIPART_FORM_DATA);
    	
    	MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file",  file.getResource());
        
    	HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

    	ResponseEntity<ResourceResponseUtil> response = null;
    	try {
	    	response = restTemplate.postForEntity(serverUrl.concat("/transacao/processar"), requestEntity, ResourceResponseUtil.class);
    	} catch (HttpStatusCodeException e) {
    		attributes.addFlashAttribute("message", new JSONObject(e.getResponseBodyAsString()).getString("message") );
    	}
    	
    	if (response != null && response.getStatusCode().equals(HttpStatus.OK)) {
    		return "redirect:/listar";
    	}
    	return "redirect:/";
    }
    
    /**
     * Recebe a requisicao da pagina de listagem e encaminha para a API
     * para retornar os dados
     *   
     * @param model
     * @return
     */
    @GetMapping("/listar")
    public String showAll(Model model) {
    	RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResourceResponseUtil> response = restTemplate.exchange(
        		URI.create(serverUrl.concat("/transacao/listar")), 
        		HttpMethod.GET, null,
          new ParameterizedTypeReference<ResourceResponseUtil>(){});

        ResourceResponseUtil result = response.getBody();
        ArrayList<LinkedHashMap<String, Object>> map = result != null ? (ArrayList<LinkedHashMap<String, Object>>)result.getPayload() : null;
    	model.addAttribute("transacoes", map);
    	return "result-list";
    }
    
}
