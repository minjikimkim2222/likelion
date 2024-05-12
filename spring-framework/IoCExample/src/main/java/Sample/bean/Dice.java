package Sample.bean;

public class Dice {
    private int face;
    public Dice(){
        System.out.println("Dice 객체 생성 !!");
    }

    public Dice(int face){
        System.out.println("Dice(int) 객체 생성 !!");
        this.face = face;
    }

    public int getNumber(){
        return (int)(Math.random() * face) + 1;
    }
}
