package com.schwan.model.impl;

import com.schwan.dto.Product;
import com.schwan.model.BarcodeInterface;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Semantics3LookupTest {

    BarcodeInterface barcodeInterface = new Semantics3Lookup();

    public static final String SOY_SAUCE_BARCODE_NUMBER = "078895126389";

    @Test
    public void testSoySauceLookup() {
        Product result = barcodeInterface.lookupBarcode(SOY_SAUCE_BARCODE_NUMBER);
        System.out.println(result);
        assertNotNull(result);
        assertEquals("Name didn't match expected", "Lee Kum Kee Premium Dark Soy Sauce", result.getTitle());
    }
}
