package com.shop.common;

import java.lang.reflect.Field;

public class MyUtils {
    public static void upd(Object oldObject, Object newObject, Class clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(newObject) == null) {
                    field.set(newObject, field.get(oldObject));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
