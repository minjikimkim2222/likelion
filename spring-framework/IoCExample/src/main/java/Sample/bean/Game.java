package Sample.bean;

import java.util.List;

public class Game {
    private List<Player> list; // Game 객체는 Player 객체에 의존한다..

    public Game(){
        System.out.println("Game() 생성자 생성 !!");
    }

    // Game객체는 생성자를 이용해 Player 객체를 주입할 것이기에, 필요한 Game 생성자를 정의했다 ..
    public Game(List<Player> list){
        System.out.println("Game(List<Player>) 생성자 실행 !!");
        this.list = list;
    }

    public void play(){
        for (Player player : list){
            player.play();
        }
    }

}
