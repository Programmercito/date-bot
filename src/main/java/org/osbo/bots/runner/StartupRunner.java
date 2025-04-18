package org.osbo.bots.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {
    @Value("${telegram.token}")
    private String telegramToken;

    @Override
    public void run(String... args) throws Exception {
        // Código que se ejecuta al iniciar la app
        System.out.println("La aplicación se ha iniciado." + telegramToken);
    }
}