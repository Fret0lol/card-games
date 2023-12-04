package com.oc.cardgame.view;

import java.util.List;
import java.util.ArrayList;

import com.oc.cardgame.controller.GameController;

public class GameViewables implements GameViewable {

  List<GameViewable> views;

  public GameViewables() {
    views = new ArrayList<GameViewable>();
  }

  public void addViewable(GameViewable view) {
    views.add(view);
  }

  @Override
  public void setController(GameController gc) {
    for (GameViewable view: views) {
      view.setController(gc);
    }
  }

  @Override
  public void promptForPlayerName() {
    for (GameViewable view : views) {
      view.promptForPlayerName();
    }
  }

  @Override
  public void promptForFlip() {
    for (GameViewable view : views) {
      view.promptForFlip();
    }
  }

  @Override
  public void promptForNewGame() {
    for (GameViewable view : views) {
      view.promptForNewGame();
    }
  }

  @Override
  public void showWinner(String name) {
    for (GameViewable view : views) {
      view.showWinner(name);
    }
  }

  @Override
  public void showPlayerName(int playerIndex, String playerName) {
    for (GameViewable view : views) {
      view.showPlayerName(playerIndex, playerName);
    }
  }

  @Override
  public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
    for (GameViewable view : views) {
      view.showFaceDownCardForPlayer(playerIndex, playerName);
    }
  }

  @Override
  public void showCardForPlayer(int playerIndex, String playerName, String playerRank, String playerSuit) {
    for (GameViewable view : views) {
      view.showCardForPlayer(playerIndex, playerName, playerRank, playerSuit);
    }
  }
  
}
