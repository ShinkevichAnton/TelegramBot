package trainee.Bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import trainee.Bot.model.City;
import trainee.Bot.service.CityService;


public class Bot extends TelegramLongPollingBot {

	@Autowired
	private CityService cityService;
	
	// незавершенный метод
	/*@Override
	public void onUpdateReceived(Update update) {

		String message = update.getMessage().getText();
		City city = new City();
		city.setName(message);
		if(message.equals(cityService.findByName(Example.of(city)))){
		sendMsg(update.getMessage().getChatId().toString(), city.getInformation());
		}else{
			sendMsg(update.getMessage().getChatId().toString(), "Такого города у нас нет(((");
		}

	}*/

	@Override
	public void onUpdateReceived(Update update) {

		String message = update.getMessage().getText();

		sendMsg(update.getMessage().getChatId().toString(), message);


	}

	@Override
	public String getBotUsername() {
		return "@trainee_tourist_bot";
	}

	@Override
	public String getBotToken() {
		return "908613952:AAESAapnN4w6AHAai97R6KB8jnCJEiNA6bg";
	}

	public synchronized void sendMsg(String chatId, String s) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(chatId);
		sendMessage.setText(s);
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			e.toString();
		}
	}
}