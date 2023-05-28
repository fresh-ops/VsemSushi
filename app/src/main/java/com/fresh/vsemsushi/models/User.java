package com.fresh.vsemsushi.models;

import java.util.Random;

public class User {
    private static User user;
    private final int id;
    private String phone;

    private User() {
        Random random = new Random();
        this.id = random.nextInt();
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
