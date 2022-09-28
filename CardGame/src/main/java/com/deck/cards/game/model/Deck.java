package com.deck.cards.game.model;

import java.util.Stack;

import com.deck.cards.game.model.enums.CardSuit;
import com.deck.cards.game.model.enums.Face;

public class Deck extends UniqueID{

	private String deckId;

	private  Stack<Card> cards;

	
	
	public Deck() {
		super();
		this.deckId = getUID();
		this.cards =  buildDeckCards();
	}

	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}

	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}

	private Stack<Card> buildDeckCards() {
		Stack<Card> cards = new Stack<Card>();
		for(CardSuit suit : CardSuit.values()) {
			for (Face face : Face.values()) {
				cards.push(new Card(face, suit));
			}
		}
		return cards;
	}
	
	
}
