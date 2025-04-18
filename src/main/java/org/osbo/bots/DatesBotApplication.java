package org.osbo.bots;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

@SpringBootApplication
public class DatesBotApplication {
	@Value("${telegram.token}")
	private static String token;

	public static void main(String[] args) {
		TelegramBot bot = new TelegramBot(token);
		bot.setUpdatesListener(updates -> {
			for (var update : updates) {
				if (update.message() != null) {
					// handle message
					System.out.println(update.message().text());
				}
			}
			return UpdatesListener.CONFIRMED_UPDATES_ALL;
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
		SpringApplication.run(DatesBotApplication.class, args);
	}

}
