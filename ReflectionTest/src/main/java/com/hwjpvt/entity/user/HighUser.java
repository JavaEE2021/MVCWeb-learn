package com.hwjpvt.entity.user;

import com.hwjpvt.annotation.Autowired;
import com.hwjpvt.annotation.ClassType;
import com.hwjpvt.annotation.UserType;
import com.hwjpvt.entity.weapon.Gun;

@ClassType(value = "user")
public class HighUser {
    private String name;
    private Float money;

    @Autowired
    private Gun myGun;

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

    @UserType(value = "high", level = 2)
    public void setMoney(Float money) {
        this.money = money;
    }
}
