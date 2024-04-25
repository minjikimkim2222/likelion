package org.day30.실습문제;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getters

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
public class Ex05 {
    public static void main(String[] args) {
        // 제품 카테고리별 평균 가격 계산
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200.00),
            new Product("Smartphone", "Electronics", 700.00),
            new Product("Desk", "Furniture", 300.00),
            new Product("Chair", "Furniture", 150.00)
        );

        // Key - Product name, Value - average Price
        Map<String, Double> productAverage = products.stream().
                collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        productAverage.forEach((name, average ) ->
                System.out.println(name + " :" + average));



    }
}
