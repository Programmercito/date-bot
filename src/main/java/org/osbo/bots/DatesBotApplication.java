package org.osbo.bots;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;

@SpringBootApplication
public class DatesBotApplication {


	public static void main(String[] args) {
		SpringApplication.run(DatesBotApplication.class, args);
	}

}
