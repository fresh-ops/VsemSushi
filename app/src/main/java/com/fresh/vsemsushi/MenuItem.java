package com.fresh.vsemsushi;

public class MenuItem {
    private final int imageId;
    private final String name;

    public MenuItem(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
