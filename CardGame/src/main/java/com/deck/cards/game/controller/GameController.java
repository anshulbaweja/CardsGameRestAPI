package com.deck.cards.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deck.cards.game.model.Card;
import com.deck.cards.game.service.GameService;

@RestController
public class GameController {

	@Autowired
	private GameService gameService;
	
	@RequestMapping(value = "/game/new", method = RequestMethod.GET)
	String createGame() {
		return gameService.createGame();
	}
	
	@RequestMapping(value = "/game/delete", method = RequestMethod.DELETE)
	void deleteGame(String gameId) {
		gameService.deleteGame(gameId);
	}
	
	@RequestMapping(value = "/game/deck/new", method = RequestMethod.GET)
	String createDeck() {
		return gameService.createDeck();
	}
	
	@RequestMapping(value = "/game/{id}/deck/add/{deckid}", method = RequestMethod.POST)
	void addDeck(@PathVariable("id") String gameId, @PathVariable("deckid") String deckId) {
		gameService.addDeck(gameId, deckId);
	}
	
	@RequestMapping(value = "/game/{id}/player/add/{playerid}", method = RequestMethod.POST)
	void addPlayer(String gameId, @PathVariable("playerid") String playerId) {
		gameService.addPlayer(gameId, playerId);
	}

	@RequestMapping(value = "/game/player/remove", method = RequestMethod.DELETE)
	void removePlayer(String gameId, String playerId) {
		gameService.removePlayer(gameId, playerId);
	}
	
	@RequestMapping(value = "/game/player/cards", method = RequestMethod.GET)
	public List<Card> getListCards(String gameId, String playerId) {
		return gameService.getListCards(gameId, playerId);
	}
	
	@RequestMapping(value = "/game/{id}/shuffle", method = RequestMethod.POST)
	void shuffle(@PathVariable("id") String gameId) {
		gameService.shuffle(gameId);
	}
}
