package com.oc.cardgame.view;

import java.util.Scanner;

import com.oc.cardgame.controller.GameController;

public class CommandLineView implements GameViewable {

  GameController gameController;

  Scanner scanner = new Scanner(System.in);

  public void setController(GameController gc) {
    this.gameController = gc;
  }

  public void promptForPlayerName() {
    System.out.println("Enter the player name: ");
    String name = scanner.nextLine();
    if (name.isEmpty()) {
      gameController.startGame();
    } else {
      gameController.addPlayer(name);
    }
  }

  public void promptForFlip() {
    System.out.println("Press enter to reveal cards");
    scanner.nextLine();
    gameController.flipCards();
  }

  public void promptForNewGame() {
    System.out.println("Press enter to deal again");
    gameController.nextAction(scanner.nextLine());
  }

  public void showWinner(String name) {
    System.out.println("Winner is " + name + " !");
  }

  public void showPlayerName(int playerIndex, String playerName) {
    System.out.println("[" + playerIndex + "][" + playerName + "]");
  }

  public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
    System.out.println("[" + playerIndex + "][" + playerName + "][x][x]");
  }

  public void showCardForPlayer(int playerIndex, String playerName, String playerRank, String playerSuit) {
    System.out.println("[" + playerIndex + "][" + playerName + "][" + playerRank + "][" + playerSuit + "]");
  }
}
