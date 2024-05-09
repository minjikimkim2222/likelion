package tv;

public class LTV implements TV{
    public void turnOn(){
        System.out.println("Ltv를 킵니다.");
    }
    public void turnOff(){
        System.out.println("Ltv를 끕니다.");
    }
    public void volumnUp(){
        System.out.println("Ltv의 소리를 높입니다.");
    }
    public void volumnDown(){
        System.out.println("Ltv의 소리를 줄입니다.");
    }
}
