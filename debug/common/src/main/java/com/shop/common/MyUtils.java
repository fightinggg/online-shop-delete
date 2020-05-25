package com.shop.common;

import java.lang.reflect.Field;

public class MyUtils {
    public static void upd(Object oldObject, Object newObject, Class clazz) {
        upd(oldObject, newObject, clazz);
    }

    public static void upd(Object oldObject, Class oldClazz, Object newObject, Class newClazz) {
        for (Field field : newClazz.getDeclaredFields()) {
            try {
                if (field.get(newObject) == null) {
                    String name = field.getName();
                    field.set(newObject, oldClazz.getField(name).get(oldObject));
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                // do nothing
                e.printStackTrace();
            }
        }
    }
}
