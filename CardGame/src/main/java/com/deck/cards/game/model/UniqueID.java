package com.deck.cards.game.model;

import java.util.UUID;

public class UniqueID {

	
	private final String uID;

	public UniqueID() {
		uID = UUID.randomUUID().toString();
	}

	public String getUID() {
		return uID;
	}
}
