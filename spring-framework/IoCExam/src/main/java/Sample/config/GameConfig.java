package Sample.config;

import Sample.bean.Dice;
import Sample.bean.Game;
import Sample.bean.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@ComponentScan(basePackages = "sample")
@PropertySource({"classpath:game.properties"})
public class GameConfig {
    // properties 전
//    @Bean
//    public Dice dice(){
//        return new Dice(6);
//    }

    @Bean
    public Dice dice(@Value("${face}") int face){
        return new Dice(face);
    }

    @Bean
    public Player minjiki2(Dice dice){ // player 객체에 dice 객체를, 나중에 spring ioc container가 의존성 주입해줄 것!!
            // 이때 매개변수 Dice - 빈 타입, dice - 빈 id 타입으로 잘 지켜줘야 함 !!
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드.. (setter 방식으로 주입!!)
        player.setName("minjiki2");

        return player;
    }

    @Bean
    public Player kim(Dice dice){ // player 객체에 dice 객체를, 나중에 spring ioc container가 의존성 주입해줄 것!!
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드.. (setter 방식으로 주입!!)
        player.setName("김길동");

        return player;
    }

    @Bean
    public Player hong(Dice dice){ // player 객체에 dice 객체를, 나중에 spring ioc container가 의존성 주입해줄 것!!
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드.. (setter 방식으로 주입!!)
        player.setName("홍길동");

        return player;
    }

    @Bean
    public Player lee(Dice dice){ // player 객체에 dice 객체를, 나중에 spring ioc container가 의존성 주입해줄 것!!
        Player player = new Player();
        player.setDice(dice); // dice를 주입하고 있는 코드.. (setter 방식으로 주입!!)
        player.setName("이길동");

        return player;
    }

    // 위의 player 들은 이름만 다름..

    @Bean
    public Game game(List<Player> players){ // 생성자를 이용해 주입..
        return new Game(players);
    }
}
