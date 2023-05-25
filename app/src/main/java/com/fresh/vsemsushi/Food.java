package com.fresh.vsemsushi;

public class Food {
    private final int imageId;
    private final String name;
    private final int cost;

    public Food(int imageId, String name, int cost) {
        this.imageId = imageId;
        this.name = name;
        this.cost = cost;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
