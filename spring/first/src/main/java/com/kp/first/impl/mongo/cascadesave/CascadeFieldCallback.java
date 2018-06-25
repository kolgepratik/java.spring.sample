package com.kp.first.impl.mongo.cascadesave;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

public class CascadeFieldCallback implements ReflectionUtils.FieldCallback {

    private Object sourceObject;
    private MongoOperations mongoOperations;

    public CascadeFieldCallback(final Object sourceObject, final MongoOperations mongoOperations) {
        this.sourceObject = sourceObject;
        this.mongoOperations = mongoOperations;
    }

    @Override public void doWith(Field field)
        throws IllegalArgumentException, IllegalAccessException {

        System.out.println("CascadeCallback: doWith. Field: " + field.getName());

        ReflectionUtils.makeAccessible(field);

        // Check if this field is DBRef and ACascadeSave annotated.
        if (field.isAnnotationPresent(DBRef.class) && field
            .isAnnotationPresent(ACascadeSave.class)) {
            if (Collection.class.isAssignableFrom(field.getType())) {
                final Object fieldValue = field.get(sourceObject);
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Class<?> actualType = (Class<?>) parameterizedType.getActualTypeArguments()[0];

                for (Object obj : ((Collection) fieldValue)) {
                    save(actualType.cast(obj));
                }
            } else {
                final Object fieldValue = field.get(sourceObject);

                save(fieldValue);
            }
        }
    }

    private void save(Object fieldValue) {
        // Check every field in this Object's value to find the value of @Id field if any.
        if (fieldValue != null) {
            final CheckIDFieldCallback callback = new CheckIDFieldCallback(fieldValue);

            ReflectionUtils.doWithFields(fieldValue.getClass(), callback);

            // If @Id field is found and is null, persist the Object in MongoDB.
            if (callback.isIdFound() && !callback.isIdNotNull()) {
                System.err.println("Saving unsaved dbref referenced object: " + fieldValue);
                mongoOperations.save(fieldValue);
            }
        }
    }
}
