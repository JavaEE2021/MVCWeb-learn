package com.company;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        var c = MyFieldTest.class;
        for (Field f : c.getDeclaredFields()) {
            if (f.isAnnotationPresent(MyField.class)) {
                var annotation = f.getAnnotation(MyField.class);
                System.out.println("字段:[" + f.getName() + "], 描述:[" + annotation.description() + "], 长度:[" + annotation.length() + "]");
            }
        }
    }
}
