package com.hwjpvt.entity.user;

import com.hwjpvt.annotation.ClassType;
import com.hwjpvt.annotation.UserType;

@ClassType(value = "user")
public class NormalUser implements User {
    private String name;
    private Float money;

    public void say() {
        System.out.println(name + "有" + money + "元");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    @UserType(value = "normal", level = 1)
    public void setMoney(Float money) {
        this.money = money;
    }
}
