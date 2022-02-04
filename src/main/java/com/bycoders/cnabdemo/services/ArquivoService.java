package com.bycoders.cnabdemo.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bycoders.cnabdemo.config.FileStorageProperties;
import com.bycoders.cnabdemo.exceptions.FileStorageException;

@Service
public class ArquivoService {

	private final Path fileStorageLocation;

	@Autowired
	public ArquivoService(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Não foi possível criar o local para gravação.", ex);
		}
	}

	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return targetLocation.toAbsolutePath().toString();
		} catch (IOException ex) {
			throw new FileStorageException("Não foi possível gravar o arquivo " + fileName + "", ex);
		}
	}

}