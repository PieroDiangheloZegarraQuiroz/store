package com.yactayo.xprs.modelsDTO;

public class DetailReceipt {
    private int idDetailReceipt;
    private double price;
    private int quantity;
    private Receipt receipt;
    private Product product;


    public DetailReceipt() {
    }

    public int getIdDetailReceipt() {
        return idDetailReceipt;
    }

    public void setIdDetailReceipt(int idDetailReceipt) {
        this.idDetailReceipt = idDetailReceipt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
