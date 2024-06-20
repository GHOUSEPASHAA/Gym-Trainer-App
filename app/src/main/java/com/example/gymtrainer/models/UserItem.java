package com.example.gymtrainer.models;

public class UserItem {
    private String username;
    private String itemName;
    private String itemPrice;

    public UserItem() {
        // Default constructor required for calls to DataSnapshot.getValue(UserItem.class)
    }

    public UserItem(String username, String itemName, String itemPrice) {
        this.username = username;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
