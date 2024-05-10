package Sample.bean;

public class Dice {
    private int face;

    public Dice(){
        System.out.println("Dice() 객체 생성 !!");
    }

    public Dice(int face){
        this.face = face;
        System.out.println("Dice(int) 객체 생성 !!");
    }

    public int getNumber(){
        return (int)(Math.random() * face) + 1; // 1 ~ 6 중 랜덤 값 리턴
    }

}
