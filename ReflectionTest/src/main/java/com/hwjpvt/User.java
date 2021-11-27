package com.hwjpvt;

public class User {
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

    public void setMoney(Float money) {
        this.money = money;
    }
}
