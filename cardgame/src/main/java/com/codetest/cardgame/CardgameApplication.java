package com.codetest.cardgame;

import com.codetest.cardgame.model.CardDeck;
import com.codetest.cardgame.service.CardHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardgameApplication {


	public static void main(String[] args) {

		SpringApplication.run(CardgameApplication.class, args);
		CardHandler.getRandom(1,4);
	}

}
