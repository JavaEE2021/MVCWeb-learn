package com.hwjpvt;

import com.hwjpvt.annotation.Autowired;
import com.hwjpvt.annotation.ClassType;
import com.hwjpvt.annotation.UserType;
import com.hwjpvt.entity.weapon.Gun;

import java.util.List;
import java.util.Objects;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        var c1 = Class.forName("com.hwjpvt.entity.user.NormalUser");
        var c2 = Class.forName("com.hwjpvt.entity.user.HighUser");
        var c3 = Class.forName("com.hwjpvt.entity.user.NormalUser");
        var c4 = Class.forName("com.hwjpvt.entity.user.HappyUser");

        var clazzList = List.of(c1, c2, c3, c4);

        int cnt = 0;

        for (var clazz : clazzList) {
            cnt += 1;
            var clazzType = clazz.getAnnotation(ClassType.class);
            if (clazzType != null) {
                if (Objects.equals(clazzType.value(), "user")) {
                    // 获取类的无参构造器对象并实例化User
                    var constructor = clazz.getDeclaredConstructor();
                    var obj = constructor.newInstance();

                    // 获取属性
                    var fields = clazz.getDeclaredFields();
                    // 可以获取属性上的注解
                    for (var field : fields) {
                        System.out.println("field name: " + field.getName() + ", type: " + field.getType());
                        var autowired = field.getAnnotation(Autowired.class);
                        if (autowired != null) {
                            System.out.println("用户需要一个 " + field.getType() + ", 记得创建");
                        }
                    }

                    // 通过反射方法设置属性
                    var setName = clazz.getMethod("setName", String.class);
                    setName.invoke(obj, "user" + cnt);
                    var setMoney = clazz.getMethod("setMoney", Float.class);

                    // 可以获取方法上的注解
                    var annotation = setMoney.getAnnotation(UserType.class);
                    if (annotation != null) {
                        if (annotation.level() <= 1) {
                            setMoney.invoke(obj, 15f);
                        } else {
                            setMoney.invoke(obj, 150f);
                        }
                    }

                    // 也可以执行无参方法
                    var say = clazz.getMethod("say");
                    say.invoke(obj);
                } else {
                    System.out.println("未处理的ClassType类型");
                }
            } else {
                System.out.println("压根儿没有ClassType");
            }

            System.out.println();
        }
    }
}
