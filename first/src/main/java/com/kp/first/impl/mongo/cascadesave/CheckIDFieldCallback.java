package com.kp.first.impl.mongo.cascadesave;

import org.springframework.data.annotation.Id;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class CheckIDFieldCallback implements ReflectionUtils.FieldCallback {
    private boolean idFound;
    private boolean idNotNull;
    private Object sourceObject;

    public CheckIDFieldCallback(Object sourceObject) {
        this.sourceObject = sourceObject;
    }

    @Override public void doWith(final Field field)
        throws IllegalArgumentException, IllegalAccessException {

        ReflectionUtils.makeAccessible(field);

        if (field.isAnnotationPresent(Id.class)) {
            idFound = true;
            final Object fieldValue = field.get(sourceObject);
            if (fieldValue != null) {
                idNotNull = true;
            }
        }
    }

    public boolean isIdFound() {
        return idFound;
    }

    public boolean isIdNotNull() {
        return idNotNull;
    }
}
