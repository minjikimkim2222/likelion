package org.day23.InterfaceEx;

public class IntegerContainer implements Container<Integer>{
    private Integer value;
    @Override
    public void set(Integer value){
        this.value = value;
    }

    @Override
    public Integer get(){
        return this.value;
    }

    public static void main(String[] args) {
        Container<Integer> integerContainer = new IntegerContainer();

        integerContainer.set(1);
        System.out.println(integerContainer.get());
    }

}
