package com.oc.cardgame.model;


import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck {
  protected List<PlayingCard> cards;

  public void shuffle() {
    Random random = new Random();
    for (int i = 0; i < cards.size(); i++) {
      Collections.swap(cards, i, random.nextInt(cards.size()));
    }
  }

  public PlayingCard removeTopCard() {
    return cards.remove(0);
  }

  public void returnCardToDeck(PlayingCard card) {
    cards.add(card);
  }

  public List<PlayingCard> getCards() {
    return cards;
  }
}
