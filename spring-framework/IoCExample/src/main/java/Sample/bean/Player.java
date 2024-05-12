package Sample.bean;

public class Player {
    private String name;
    private Dice dice; // Player는 Dice객체에 의존한다..

    // DI할 수 있는 방법은? --> GameConfig.java ..
        // 1. setter를 통한 의존성 주입
        // 2. 생성자를 통한 의존성 주입
        // 3, 필드를 통한 의존성 주입 (no 추천..)
    public Player(){
        System.out.println("player 객체 생성 !!");
    }

    // Player는 Dice 객체 주입을 setter로 할 것이기에, setDice()를 정의했다 ..
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    // Dice dice 사용
    public void play(){
        System.out.println(name + "은 주사위를 던져서 " + dice.getNumber() + "가 나왔습니다.");
    }
}
