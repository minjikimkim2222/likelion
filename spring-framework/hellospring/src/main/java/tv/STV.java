package tv;

public class STV implements TV{
    // 기능 - 끄다, 켜다, 소리 높이다, 소리 줄이다
    public void turnOn(){
        System.out.println("Stv를 킵니다.");
    }
    public void turnOff(){
        System.out.println("Stv를 끕니다.");
    }
    public void volumnUp(){
        System.out.println("Stv의 소리를 높입니다.");
    }
    public void volumnDown(){
        System.out.println("Stv의 소리를 줄입니다.");
    }
}
