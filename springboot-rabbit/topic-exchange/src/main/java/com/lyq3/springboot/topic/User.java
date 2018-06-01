package com.lyq3.springboot.topic;

import java.io.Serializable;

/**
 * @author 卡卢比
 * 用户实体类
 */
public class User implements Serializable {
    private String name;
    private int age;
    private char sex;
    private Integer height;
    private Double weight;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public User setAge(int age) {
        this.age = age;
        return this;
    }

    public char getSex() {
        return sex;
    }

    public User setSex(char sex) {
        this.sex = sex;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public User setHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Double getWeight() {
        return weight;
    }

    public User setWeight(Double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
