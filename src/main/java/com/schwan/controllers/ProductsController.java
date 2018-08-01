package com.schwan.controllers;

import com.schwan.dto.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Product greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Product("1",
                String.format(template, name));
    }
}
