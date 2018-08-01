package com.schwan.dto;

public class Product {

    private String barcode;
    private String title;

    public Product() {}

    public Product(String barcode, String title) {
        this();
        this.barcode = barcode;
        this.title = title;
    }

    public String getBarcode() {
        return barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Product => [" +
                "barcode=" + getBarcode() +
                ", title=" + getTitle() +
                "]";

    }
}