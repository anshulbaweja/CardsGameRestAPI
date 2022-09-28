package com.deck.cards.game.model;

import com.deck.cards.game.model.enums.CardSuit;
import com.deck.cards.game.model.enums.Face;

public class Card {

	private Face faceValue;
	private CardSuit suit;
	

	public Card(Face faceValue, CardSuit suit) {
		super();
		this.faceValue = faceValue;
		this.suit = suit;
	}


	public Face getFaceValue() {
		return faceValue;
	}

	public CardSuit getSuit() {
		return suit;
	}
	

	@Override
	public String toString() {
		return "Card [faceValue=" + faceValue + ", suit=" + suit + "]";
	}


	public int compareTo(Card otherCard) {
		int compareFace = Integer.compare(this.getFaceValue().getValue(), otherCard.getFaceValue().getValue());
		return compareFace != 0 ? compareFace
				: Integer.compare(this.getSuit().getValue(), otherCard.getSuit().getValue());
	}
	

	
	
	
}
