package com.bycoders.cnabdemo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author patrik
 * Annotation responsavel por mapear e delimitar as 
 * posicoes do arquivo que será lido.
 * Dessa forma, é possível fazer um parser para um layout
 * diferente de forma bastante rápida, exigindo apenas 
 * o mapeamento de um novo DTO 
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EDITextField {
	
    // posicao inicial da leitura da linha
    public int start();
    // posicao final da leitura da linha
    public int end();
    
}
