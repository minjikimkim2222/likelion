package com.example.day02.연산자;

public class Book {
    private String title;
    static int price;

    // 메서드 - setter, getter

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int newPrice) {

        price = newPrice;
    }
}
