package org.day23;

import java.util.Date;

public class Pair<K,V> { // K : key, V : value
    private K key;
    private V value;

    // default constructor
    public Pair(){

    }
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    // getters and setters
    public K getKey(){
        return this.key;
    }

    public void setKey(K key){
        this.key = key;
    }

    public V getValue(){
        return this.value;
    }

    public void setValue(V value){
        this.value = value;
    }

    public static void main(String[] args) {
        // 제너릭 타입은, 객체가 생성될 때 결정된다!!
        Pair<String, Integer> pair = new Pair<>("age", 23);
        Pair<String, String> pair2 = new Pair<>("name", "minjiki2");

        System.out.println("key - age : " + pair.getValue()); // key - age : 23
        System.out.println("key - name : " + pair2.getValue()); // key - name : minjiki2

        // 디폴트 생성자 이후, setter로 값 설정하기
        Pair<String, Date> pair3 = new Pair<>();
        pair3.setKey("today's Date");
        pair3.setValue(new Date());

        System.out.println(pair3.getKey() + " - " + pair3.getValue()); // today's Date - Mon Apr 15 10:49:48 KST 2024
    }
}
