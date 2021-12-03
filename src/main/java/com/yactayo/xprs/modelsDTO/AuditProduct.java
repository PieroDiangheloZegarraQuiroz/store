package com.yactayo.xprs.modelsDTO;
import java.util.Date;

public class AuditProduct {

    private int idAudiProduct;
    private Date date;
    private Product product;
    private Category category;
    private String event;
    private String nameOld;
    private String newName;
    private double priceOld;
    private double priceNew;
    private int stockOld;
    private int stockNew;
    private String author;

    public AuditProduct(Date date, String event, String nameOld, String newName, double priceOld, double priceNew, int stockOld, int stockNew, String author) {

        this.date = date;
        this.event = event;
        this.nameOld = nameOld;
        this.newName = newName;
        this.priceOld = priceOld;
        this.priceNew = priceNew;
        this.stockOld = stockOld;
        this.stockNew = stockNew;
        this.author = author;
    }

    public int getIdAudiProduct() {
        return idAudiProduct;
    }

    public void setIdAudiProduct(int idAudiProduct) {
        this.idAudiProduct = idAudiProduct;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getNameOld() {
        return nameOld;
    }

    public void setNameOld(String nameOld) {
        this.nameOld = nameOld;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public double getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(double priceOld) {
        this.priceOld = priceOld;
    }

    public double getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(double priceNew) {
        this.priceNew = priceNew;
    }

    public int getStockOld() {
        return stockOld;
    }

    public void setStockOld(int stockOld) {
        this.stockOld = stockOld;
    }

    public int getStockNew() {
        return stockNew;
    }

    public void setStockNew(int stockNew) {
        this.stockNew = stockNew;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
