package com.schwan.model.impl;

import com.schwan.dto.Product;
import com.schwan.model.BarcodeInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BarcodeLookupTest {

    BarcodeInterface barcodeInterface = new BarcodeLookup();

    public static final String SOY_SAUCE_BARCODE_NUMBER = "078895126389";

    @Test
    public void testSoySauceLookup() {
        Product result = barcodeInterface.lookupBarcode(SOY_SAUCE_BARCODE_NUMBER);
        assertNotNull(result);
        assertEquals("LEE KUM KEE Dark Soy Sauce 500ml", result.getTitle(), "Name didn't match expected");
    }
}
