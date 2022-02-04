package com.bycoders.cnabdemo.helper;

import com.bycoders.cnabdemo.annotations.EDITextField;
import com.bycoders.cnabdemo.utils.CnabDemoUtils;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class EDITextInterpreter {

    private static final Logger LOG = Logger.getLogger(EDITextInterpreter.class.getName());
    private String linha;

    public EDITextInterpreter readLine() {
        try {
            Class<?> objectClass = CnabDemoUtils.requireNonNull(this).getClass();
            for (Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(EDITextField.class)) {
                    EDITextField saptext = field.getAnnotation(EDITextField.class);
                    String value = linha.substring(saptext.start(), saptext.end());
                    LOG.log(Level.INFO, "Field: {0} ==>>  start: {1}  end: {2} value: {3}", new Object[]{field, saptext.start(), saptext.end(), value});
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
