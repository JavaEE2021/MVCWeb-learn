package com.hwjpvt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        var clazz = Class.forName("com.hwjpvt.User");

        // 获取类的无参构造器对象并实例化User
        var cons = clazz.getDeclaredConstructor();
        var obj = cons.newInstance();

        // 通过反射方法设置属性
        var setName = clazz.getMethod("setName", String.class);
        setName.invoke(obj, "admin");
        var setMoney = clazz.getMethod("setMoney", Float.class);
        setMoney.invoke(obj, 15f);

        // 也可以执行无参方法
        var say = clazz.getMethod("say");
        say.invoke(obj);
    }
}
