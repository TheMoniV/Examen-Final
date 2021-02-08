package org.sid;

import org.sid.graphics.*;
import org.sid.graphics.parameters.Observer;
import org.sid.graphics.parameters.Parameters;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Examen {

    public static void main(String[] args) {
        SpringApplication.run(Examen.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, Scene scene) {
        return args -> {
            scene.addGraphic(new Circle(new Point(5, 5), 5));
            scene.addGraphic(new Rectangle(new Point(20, 25), 15, 10));
            List<Observer> observers=new ArrayList<>(scene.getList());
            Parameters parameters = new Parameters(10,10,10,observers);
            for (Graphic figure : scene.getList()) {
                figure.setParameters(parameters);
            }
            parameters.setColorContour(12);
            scene.showScene();
        };
    }
}
