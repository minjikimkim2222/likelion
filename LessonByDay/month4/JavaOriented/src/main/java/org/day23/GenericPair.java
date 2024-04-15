package org.day23;

public class GenericPair<T1, T2> { // 타입은 객체가 '생성될 때' 결정된다
    private T1 first;
    private T2 second;

    // default 생성자
    public GenericPair(){

    }

    public GenericPair(T1 first, T2 second){
        this.first = first;
        this.second = second;
    }

    // getters and setters

    public T1 getFirst(){
        return first;
    }

    public void setFirst(T1 first){
        this.first = first;
    }

    public T2 getSecond(){
        return second;
    }

    public void setSecond(T2 second){
        this.second = second;
    }

    public static void main(String[] args) {
        // (다시 말하지만), 제너릭의 타입은, 객체가 생성되는 시점에 결정된다!
        GenericPair<String, Integer> pair = new GenericPair<>("minjiki2", 23);
        String myName = pair.getFirst();
        int myAge = pair.getSecond();

        GenericPair<String, Integer> pair2 = new GenericPair<>();
        pair2.setFirst("gooooood");
        pair2.setSecond(10);

        System.out.println("pair2, getFirst : " + pair2.getFirst()); // gooooood
        System.out.println("pair2, getSecond : " + pair2.getSecond()); // 10
    }
}
