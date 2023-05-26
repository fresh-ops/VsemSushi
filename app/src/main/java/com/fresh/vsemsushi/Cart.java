package com.fresh.vsemsushi;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart cart;
    private static final List<Food> list = new ArrayList<>();
    private Cart() {}

    public static Cart getInstance() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    public List<Food> getList() {
        return list;
    }

    public int getCost() {
        int cost = 0;
        for (int i = 0; i < list.size(); i++) {
            cost += list.get(i).getCost();
        }
        return cost;
    }

    public void add(Food food) {
        list.add(food);
    }

    public void clearCart() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
