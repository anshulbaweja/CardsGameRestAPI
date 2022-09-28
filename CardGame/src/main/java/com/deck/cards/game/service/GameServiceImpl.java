package com.deck.cards.game.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.deck.cards.game.model.Card;
import com.deck.cards.game.model.Deck;
import com.deck.cards.game.model.Game;
import com.deck.cards.game.model.Player;

@Component
public class GameServiceImpl implements GameService{

	private Map<String, Game> gamesMap = new HashMap<String, Game>();
	private Map<String, Deck> decksMap = new HashMap<String, Deck>();
	@Override
	public String createGame() {
		Game game = new Game();
		gamesMap.put(game.getGameId(), game);
		return game.getGameId();
	}

	
	@Override
	public void deleteGame(String gameId) {
		Game game = this.gamesMap.get(gameId);
		this.gamesMap.remove(game.getGameId());
		
	}


	@Override
	public String createDeck() {
		Deck deck = new Deck();
		decksMap.put(deck.getDeckId(), deck);
		return deck.getDeckId();
	}


	@Override
	public void addDeck(String gameId, String deckId) {
		Game game = this.gamesMap.get(gameId);
		
		Deck deck =this.decksMap.get(deckId);
		
		game.getGameDeck().getCards().addAll(deck.getCards());
		
	}


	@Override
	public void addPlayer(String gameId, String playerId) {
		Game game = this.gamesMap.get(gameId);
		
		game.getPlayers().add(new Player(playerId));
		
	}

	private Optional<Player> getPlayer(String playerId, Game game) {
		return game.getPlayers().stream().filter(p -> playerId.equals(p.getPlayerId())).findAny();
	}

	@Override
	public void removePlayer(String gameId, String playerId) {
		Game game = this.gamesMap.get(gameId);

		Player player = getPlayer(playerId, game).get();

		game.getPlayers().remove(player);
		
	}
	
	@Override
	public List<Card> getListCards(String gameId, String playerId) {
		Game game = this.gamesMap.get(gameId);

		Player player = getPlayer(playerId, game).get();

		return player.getCards();
	}
	
	@Override
	public void shuffle(String gameId) {
		Game game = this.gamesMap.get(gameId);

		Random random = new Random();
		int size = game.getGameDeck().getCards().size();
		for (int i = 0; i < game.getGameDeck().getCards().size(); i++) {
			Card card = game.getGameDeck().getCards().get(i);

			int randomIndex = random.nextInt(size - i) + i;
			game.getGameDeck().getCards().set(i, game.getGameDeck().getCards().get(randomIndex));
			game.getGameDeck().getCards().set(randomIndex, card);
		}
	}

}
