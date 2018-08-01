package com.schwan.model;

import com.schwan.dto.Product;

public abstract class BarcodeInterface {

    public abstract Product lookupBarcode(String barcodeNumber);

    protected void cleanProduct(Product product) {
        product.setTitle(cleanTitle(product.getTitle()));
    }

    protected String cleanTitle(String input) {
        // TODO: does anything else need cleaning?
        return input.substring(0, input.indexOf(","));
    }
}
