package com.hwjpvt.entity.weapon;

public class Gun {
    private String name;
    private Float power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Gun{" +
                "name='" + name + '\'' +
                ", power=" + power +
                '}';
    }
}
