package com.schwan.model.impl;

import com.schwan.dto.Product;
import com.schwan.model.BarcodeInterface;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Interface for https://www.barcodelookup.com/api
 */
public class BarcodeLookup extends BarcodeInterface {


    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String HTTP_STEM = "https://www.barcodelookup.com/";

    public Product lookupBarcode(String barcodeNumber) {
        try {
            return getRequest(HTTP_STEM + barcodeNumber);
//            return parseHtml(HTTP_STEM + barcodeNumber);
        } catch (Exception e) {
            System.err.println("Exception thrown: " + e);
        }
        return null;
    }

    private Product getRequest(String url) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader rd = new BufferedReader( new InputStreamReader(con.getInputStream()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return parseHtml(result.toString());

    }

    private Product parseHtml(String html) throws Exception {
        System.out.println("html = " + html);
//        System.out.println("going to " + address);
//        URL url = new URL(address);
//        Document doc = Jsoup.parse(url, 1000);
//        System.out.println("doc = " + doc);
        Document doc = Jsoup.parse(html);
        System.out.println("Doc = " + doc);
        Elements ele2 = doc.body().getAllElements();
        System.out.println("ele2   = " + ele2);
        Elements productDetailsDiv = doc.getElementsByClass("product-details");
        System.out.println("productDetails = " + productDetailsDiv);

        Product product = new Product();
        return product;
    }
}
