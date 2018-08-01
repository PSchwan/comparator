package com.schwan.model.impl;

import com.schwan.dto.Product;
import com.schwan.model.BarcodeInterface;

import com.schwan.utils.SystemProperties;
import com.semantics3.api.Products;
import org.json.JSONArray;
import org.json.JSONObject;

public class Semantics3Lookup extends BarcodeInterface {

    public Product lookupBarcode(String barcodeNumber) {
        try {
            System.out.println("looking up " + barcodeNumber);
            JSONObject json = getDetailsFromSemantics(barcodeNumber);
            Product product = buildProductFromJSON(json);
            cleanProduct(product);
            return product;

        } catch (Exception e) {
            System.err.println("Error thrown: " + e);
        }

        return null;
    }

    private JSONObject getDetailsFromSemantics(String barcode) throws Exception {

        Products productLookupAPI = new Products(
                SystemProperties.get(SystemProperties.PROP_SEMANTICS_API_KEY),
                SystemProperties.get(SystemProperties.PROP_SEMANTICS_API_SECRET));

        productLookupAPI.productsField("upc", barcode);
        JSONObject results = productLookupAPI.get();

        JSONArray results2 = results.getJSONArray("results");

        if(results2.length() <= 0) {
            System.err.println("No Product found with barcode: " + barcode);
            return null;
        } else if(results2.length() > 1) {
            System.err.println("More than one product found");
        }

        return results2.getJSONObject(0);
    }

    private Product buildProductFromJSON(JSONObject object) {
        Product product = new Product();
        product.setBarcode(object.getString("upc"));
        product.setTitle(object.getString("name"));
        return product;
    }

}
