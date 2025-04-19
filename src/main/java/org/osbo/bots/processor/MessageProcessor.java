package org.osbo.bots.processor;

import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
    public void process(Update update) {
        if (update.message() != null) {
            // Procesar mensaje
            System.out.println("[MessageProcessor] Mensaje recibido: " + update.message().text());
        } else if (update.callbackQuery() != null) {
            // Procesar callback query
            System.out.println("[MessageProcessor] Callback query recibida: " + update.callbackQuery().data());
        } else {
            System.out.println("[MessageProcessor] Update no reconocido: " + update.toString());
        }
    }
}
