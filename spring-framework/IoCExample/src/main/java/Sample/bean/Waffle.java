package Sample.bean;

import org.springframework.stereotype.Component;

@Component
public class Waffle {
    private String menu;
    private int price;

    // constructor
    public Waffle(){
        System.out.println("Waffle() 객체 생성 !!");
    }

    // getters and setters
    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "Waffle{" +
                "menu='" + menu + '\'' +
                ", price=" + price +
                '}';
    }
}
