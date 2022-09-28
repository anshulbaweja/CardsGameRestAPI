package com.deck.cards.game.service;

import java.util.List;
import com.deck.cards.game.model.Card;

public interface GameService {
	
	String createGame();
	
	void deleteGame(String gameId);

	String createDeck();
	
	void addDeck(String gameId, String deckId) ;
	
	void addPlayer(String gameId, String playerId) ;

	void removePlayer(String gameId, String playerId) ;
	
	List<Card> getListCards(String gameId, String playerId) ;

	void shuffle(String gameId) ;
}
