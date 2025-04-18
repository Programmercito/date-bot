package org.osbo.bots.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

@Component
public class StartupRunner implements CommandLineRunner {
    @Value("${telegram.token}")
    private String telegramToken;

    @Override
    public void run(String... args) throws Exception {
        // Código que se ejecuta al iniciar la app
        TelegramBot bot = new TelegramBot(telegramToken);
        bot.setUpdatesListener(updates -> {
            // ... process updates
            for (var update : updates) {
                // process each update
                if (update.message() != null) {
                    // process message
                    System.out.println("Received message: " + update.message().text());
                } else if (update.callbackQuery() != null) {
                    // process callback query
                    System.out.println("Received callback query: " + update.callbackQuery().data());
                }
            }
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
            // Create Exception Handler
        }, e -> {
            if (e.response() != null) {
                // got bad response from telegram
                e.response().errorCode();
                e.response().description();
            } else {
                // probably network error
                e.printStackTrace();
            }
        });
    }
}