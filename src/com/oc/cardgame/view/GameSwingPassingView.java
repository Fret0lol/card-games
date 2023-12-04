package com.oc.cardgame.view;

import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.oc.cardgame.controller.GameController;

public class GameSwingPassingView implements GameViewable {

  GameController controller;
  JTextArea textArea;
  JFrame frame;

  public void createAndShowGUI() {

    // create main frame
    frame = new JFrame("MVC-SOLID-Game");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);

    // display vertically
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    addControllerCommandTracker(contentPane);

    frame.setVisible(true);
  }

  private void addControllerCommandTracker(Container contentPane) {
    textArea = new JTextArea("Game Status\n", 100, 1);
    JScrollPane scrollPane = new JScrollPane(textArea);
    addCenteredComponent(scrollPane, contentPane);
    textArea.setSize(500, 500);
  }

  private void addCenteredComponent(JComponent component, Container container) {
    component.setAlignmentX(Component.CENTER_ALIGNMENT);
    container.add(component);
  }

  private void appendText(String text) {
    textArea.append(text + "\n");
    textArea.setCaretPosition(textArea.getDocument().getLength());
  }

  @Override
  public void setController(GameController gc) {
    this.controller = gc;
  }

  @Override
  public void promptForPlayerName() {
    appendText("Waiting for player name ...");
  }

  @Override
  public void promptForFlip() {
    appendText("Waiting for flipping cards ...");
  }

  @Override
  public void promptForNewGame() {
    appendText("Waiting for next step ...");
  }

  @Override
  public void showWinner(String name) {
    appendText("Winner!\n" + name);
  }

  @Override
  public void showPlayerName(int playerIndex, String playerName) {
    appendText("[" + playerIndex + "][" + playerName + "]");
  }

  @Override
  public void showFaceDownCardForPlayer(int playerIndex, String playerName) {
    appendText("[" + playerName + "][][]");
  }

  @Override
  public void showCardForPlayer(int playerIndex, String playerName, String playerRank, String playerSuit) {
    appendText("[" + playerName + "][" + playerRank + ":" + playerSuit + "]");
  }
  
}
