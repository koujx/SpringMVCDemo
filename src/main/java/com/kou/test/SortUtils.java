package com.kou.test;

import java.lang.reflect.Field;

/**
 * Created by KouJiaxing on 2017-4-18.
 */
public class SortUtils {

    public static <E> boolean sortObjectByParam(E a, E b, String sortParam) {
        Class aClass = a.getClass();
        Class bClass = b.getClass();
        Field[] fields = aClass.getFields();
        Field aField = null;
        Field bField = null;
        for (int i = 0; i < fields.length; i++) {
            aField = fields[i];
            bField = fields[i];
            if (sortParam.equals(aField)) {
                String aStr = null;
                try {
                    aStr = aField.get(a).toString();
                    String bStr = bField.get(b).toString();
                    int compare = aStr.compareTo(bStr);
                    if (compare == 1) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
