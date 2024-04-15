package org.day23;

public class NonGenericPair {
    private Object first;
    private Object second;

    public NonGenericPair(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    // getters and setters

    public Object getFirst() {
        return first;
    }

    public void setFirst(Object first) {
        this.first = first;
    }

    public Object getSecond() {
        return second;
    }

    public void setSecond(Object second) {
        this.second = second;
    }

    public static void main(String[] args) {
        // generic 사용안하고 값을 담는다면??
        NonGenericPair nonPair = new NonGenericPair("Hello", 23);
        String str = (String) nonPair.getFirst(); // 혈변환 필수!@!!
        Integer i = (Integer) nonPair.getSecond(); // // 혈변환 필수!@!!
    }
}
