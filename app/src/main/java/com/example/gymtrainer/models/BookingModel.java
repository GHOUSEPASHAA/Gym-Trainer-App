package com.example.gymtrainer.models;




public class BookingModel{
        private String name;
        private String price;
        private int imageResourceId; // you can use this to hold the resource id of the image

        public BookingModel(String name, String price, int imageResourceId) {
            this.name = name;
            this.price = price;
            this.imageResourceId = imageResourceId;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public int getImageResourceId() {
            return imageResourceId;
        }
}
