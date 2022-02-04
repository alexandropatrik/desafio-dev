package com.bycoders.cnabdemo.helper;

import com.bycoders.cnabdemo.annotations.EDITextField;
import com.bycoders.cnabdemo.utils.CnabDemoUtils;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author patrik
 *
 * Interpretador que faz o parser de cada linha do arquivo
 */
public abstract class EDITextInterpreter {

    private static final Logger LOG = Logger.getLogger(EDITextInterpreter.class.getName());
    private String linha;

    /**
     * Identifica os atributos anotados com EDITextField 
 	 * e copia dinamicamente o conteúdo para um objeto que extende essa classe
     * @return Retorna uma instância da classe com os atributos preenchidos
     */
    public EDITextInterpreter readLine() {
        try {
            Class<?> objectClass = CnabDemoUtils.requireNonNull(this).getClass();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(EDITextField.class)) {
                    EDITextField part = field.getAnnotation(EDITextField.class);
                    String value = linha.substring(part.start(), part.end());
                    LOG.log(Level.INFO, "Field: {0} ==>>  start: {1}  end: {2} value: {3}", new Object[]{field, part.start(), part.end(), value});
                    field.set(this, value);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e) {
            LOG.severe(e.getLocalizedMessage());
        }
        return this;
    }

    public void setLinha(String ilinha) {
        this.linha = ilinha;
    }

    public String getLinha() {
        return linha;
    }

}
