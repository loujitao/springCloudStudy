package com.steve.entity;

import lombok.Data;

@Data
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

}
