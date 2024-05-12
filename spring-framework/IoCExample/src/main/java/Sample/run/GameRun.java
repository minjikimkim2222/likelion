package Sample.run;

import Sample.bean.Game;
import Sample.config.GameConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class GameRun {
    public static void main(String[] args) {
        System.out.println("공장 생성 전...");
        ApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
        System.out.println("공장 생성 후...");

        Game game = context.getBean(Game.class);
        game.play();
    }
}
