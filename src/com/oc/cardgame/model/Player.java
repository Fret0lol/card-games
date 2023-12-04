package com.oc.cardgame.model;

public class Player implements IPlayer {
  private String name;
  private Hand hand;

  public Player(String name) {
    this.name = name;
    this.hand = new Hand();
  }

  public String getName() {
    return this.name;
  }

  public void addCardToHand(PlayingCard pc) {
    this.hand.addCards(pc);
  }

  public PlayingCard getCard(int index) {
    return this.hand.getCard(index);
  }

  public PlayingCard removeCard() {
    return this.hand.removeCard();
  }
}
