package com.oc.cardgame.controller;

import java.util.List;
import java.util.ArrayList;

import com.oc.cardgame.games.GameEvaluator;
import com.oc.cardgame.model.Deck;
import com.oc.cardgame.model.IPlayer;
import com.oc.cardgame.model.Player;
import com.oc.cardgame.model.PlayingCard;
import com.oc.cardgame.model.WinningPlayer;
import com.oc.cardgame.view.GameViewable;


public class GameController {

  enum GameState {
    AddingPlayers, CardsDealt, WinnerRevealed;
  }

  Deck deck;
  List<IPlayer> players;
  IPlayer winner;
  GameViewable view;

  GameState gameState;
  GameEvaluator gameEvaluator;

  public GameController(GameViewable view, Deck deck, GameEvaluator gameEvaluator) {
    this.deck = deck;
    this.view = view;
    this.players = new ArrayList<IPlayer>();
    this.gameState = GameState.AddingPlayers;
    view.setController(this);
    this.gameEvaluator = gameEvaluator;
  }

  public void run() {
    while (gameState == GameState.AddingPlayers) {
      view.promptForPlayerName();
    }

    switch (gameState) {
      case CardsDealt:
        view.promptForFlip();
        break;
      case WinnerRevealed:
        view.promptForNewGame();
        break;
    }
  }

  public void addPlayer(String name) {
    if (gameState == GameState.AddingPlayers) {
      players.add(new Player(name));
      view.showPlayerName(players.size(), name);
    }
  }

  public void startGame() {
    if (gameState != GameState.CardsDealt) {
      deck.shuffle();
      int playerIndex = 1;
      for (IPlayer player: players) {
        player.addCardToHand(deck.removeTopCard());
        view.showFaceDownCardForPlayer(playerIndex++, player.getName());
      }
      gameState = GameState.CardsDealt;
    }
    this.run();
  }

  public void flipCards() {
    int playerIndex = 1;
    for (IPlayer player: players) {
      PlayingCard pc = player.getCard(0);
      pc.flip();
      view.showCardForPlayer(playerIndex++, player.getName(), pc.getRank().toString(), pc.getSuit().toString());
    }

    evaluateWinner();
    displayWinner();
    rebuildDeck();
    gameState = GameState.WinnerRevealed;
    this.run();
  }

  public void evaluateWinner() {
    winner = new WinningPlayer(gameEvaluator.evaluateWinner(players));
  }

  void displayWinner() {
    view.showWinner(winner.getName());
  }

  void rebuildDeck() {
    for (IPlayer player: players) {
      deck.returnCardToDeck(player.removeCard());
    }
  }

  void exitGame() {
    System.exit(0);
  }

  public void nextAction(String nextLine) {
    if ("+q".equals(nextLine)) {
      exitGame();
    } else {
      startGame();
    }
  }
}
