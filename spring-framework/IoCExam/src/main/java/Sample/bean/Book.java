package Sample.bean;

import org.springframework.stereotype.Component;

@Component("b")
public class Book {
    private String title;
    private int price;

    public Book() {
        System.out.println("book 인스턴스 생성 !!");
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
