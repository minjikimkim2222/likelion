package Sample.config;

import Sample.bean.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Configuration
@PropertySource({"classpath:game.properties"})
public class GameConfig {

    // properties 전.. - 멤버변수 face가 계속 6으로 고정됨
//    @Bean
//    public Dice dice(){
//        return new Dice(6);
//    }
    @Bean
    public Dice dice(@Value("${face}") int face){
        return new Dice(face);
    }

    // Player 객체에서는, setter를 이용해, Dice 객체를 의존성 주입한다..
        // 그렇게 하기 위해 필요한 setter를 'Player 객체에' 정의해두었다!
    @Bean
    public Player player1(Dice dice){
        Player player = new Player();
        player.setDice(dice); // Player 객체에 정의해둔 setter
        player.setName("player1");

        return player;
    }

    @Bean
    public Player player2(Dice dice){
        Player player = new Player();
        player.setDice(dice); // Player 객체에 정의해둔 setter
        player.setName("player2");

        return player;
    }

    @Bean
    public Player player3(Dice dice){
        Player player = new Player();
        player.setDice(dice); // Player 객체에 정의해둔 setter
        player.setName("player3");

        return player;
    }

    // game객체는, 생성자를 통해, Player 객체를 의존성 주입시킨다..
        // 그렇게 하기 위해, 'Game 객체에' 생성자를 정의해두었다..
    @Bean
    public Game game(List<Player> players){
        return new Game(players); // Game 객체에 정의해둔 생성자 사용!
    }
}
