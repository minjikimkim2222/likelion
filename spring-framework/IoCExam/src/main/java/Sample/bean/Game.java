package Sample.bean;

import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class Game {
    private List<Player> list;

    public Game(){
        System.out.println("Game() 생성자 실행 !!");
    }

    public Game(List<Player> list){ // 생성자 주입을 위한 Game 생성자 !!
        System.out.println("Game(List<Player>) 생성자 실행 !!");
        this.list = list;
    }

    public void play(){
        for (Player player : list){
            player.play();
        }
    }
}
