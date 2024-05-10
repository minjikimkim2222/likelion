package Sample.bean;

public class Player {
    private String name;
    private Dice dice; // 실행될 때 주사위를 인젝션 받아야 한다..

    // DI할 수 있는 방법은?
        // 1. 생성자 를 통한 주입
        // 2. 설정자(setter) 를 통한 주입
        // 3. 필드 를 통한 주입
    public String getName() {
        return name;
    }

    public Dice getDice() {
        return dice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void play(){
        System.out.println(name + "은 주사위를 던져서 " + dice.getNumber() + "가 나왔습니다.");
    }
}
