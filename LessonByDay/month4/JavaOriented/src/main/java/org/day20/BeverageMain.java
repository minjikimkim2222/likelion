package org.day20;

public class BeverageMain {
    public static void main(String[] args) {
        BeverageRecipe coffee = new Coffee();
        BeverageRecipe tea = new Tea();

        coffee.prepareRecipe();
        tea.prepareRecipe();

    }
}
