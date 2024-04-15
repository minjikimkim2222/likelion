package org.day23.InterfaceEx;

public class StringContainer implements Container<String> {
    private String value;
    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return this.value;
    }


    public static void main(String[] args) {
        Container<String> stringContainer = new StringContainer();

        stringContainer.set("this is stringContainer!!");
        System.out.println(stringContainer.get());

    }
}
