package com.bycoders.cnabdemo.utils;

/**
 * 
 * @author patrik
 *
 * Classe utilitária 
 */
public class CnabDemoUtils {

    CnabDemoUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Verifica se o objeto passado é null
     * @param o Objeto a ser avaliado
     * @return Retorna o próprio objeto se ele não for nulo
     * @throws Caso o objeto seja null, dispara um NullPointerException
     */
    public static Object requireNonNull(Object o) {
        if (o != null) {
            return o;
        }
        throw new NullPointerException();
    }

}
