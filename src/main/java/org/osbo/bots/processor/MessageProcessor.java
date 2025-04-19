package org.osbo.bots.processor;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
    private final TelegramBot bot;

    public MessageProcessor(TelegramBot bot) {
        this.bot = bot;
    }

    public void process(Update update) {
        if (update.message() != null) {
            String text = update.message().text();
            Long chatId = update.message().chat().id();
            if ("/start".equals(text)) {
                String welcome = "\uD83D\uDC65 ¡Bienvenido al Bot de Anuncios de Amistad! \uD83D\uDC65\n\n" +
                        "Este bot te permite publicar anuncios de amistad en nuestro canal de Telegram. " +
                        "\n\nEscribe tu anuncio y yo lo enviaré al canal para que otros puedan conocerte.\n" +
                        "\nPor favor, no incluyas datos personales sensibles.\n" +
                        "\n¡Comienza enviando tu mensaje de presentación!";
                bot.execute(new SendMessage(chatId, welcome));
            } else if (text.startsWith("/")) {
                String unknown = "\u2753 Comando desconocido. Por favor, escribe tu anuncio de amistad o usa /start para ver mas informacion";
                bot.execute(new SendMessage(chatId, unknown));
            } else {
                System.out.println("[MessageProcessor] Mensaje recibido: " + text);
            }
        } else if (update.callbackQuery() != null) {
            System.out.println("[MessageProcessor] Callback query recibida: " + update.callbackQuery().data());
        } else {
            System.out.println("[MessageProcessor] Update no reconocido: " + update.toString());
        }
    }
}
