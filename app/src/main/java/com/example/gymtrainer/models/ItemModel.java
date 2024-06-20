package com.example.gymtrainer.models;

public class ItemModel {
    private String text;
    private int imageResource;

    public ItemModel(String text, int imageResource) {
        this.text = text;
        this.imageResource = imageResource;
    }

    public String getText() {
        return text;
    }

    public int getImageResource() {
        return imageResource;
    }
}