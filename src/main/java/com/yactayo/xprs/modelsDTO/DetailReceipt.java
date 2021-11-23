package com.yactayo.xprs.modelsDTO;

public class DetailReceipt {
    private int idDetailReceipt;
    private Receipt receipt;
    private double price;
    private Product product;
    private int quantity;




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

    @Override
    public String toString() {
        return "DetailReceipt{" +
                "idDetailReceipt=" + idDetailReceipt +
                ", receipt=" + receipt +
                ", price=" + price +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
