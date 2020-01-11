package com.ermile.jsonxml;

import androidx.annotation.NonNull;

public class Flower {
    private long productId;
    private String category;
    private String name;
    private String instruction;
    private  double price;
    private String photo;

    public Flower(){}

    public long getProductId() { return productId; }
    public void setProductId(long productId) { this.productId = productId; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getInstruction() { return instruction; }
    public void setInstruction(String instruction) { this.instruction = instruction; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }


    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
