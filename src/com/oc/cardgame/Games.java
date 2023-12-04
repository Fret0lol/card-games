package com.oc.cardgame;

import com.oc.cardgame.DeckFactory.DeckType;
import com.oc.cardgame.controller.GameController;
import com.oc.cardgame.games.HighCardGameEvaluator;
import com.oc.cardgame.games.LowCardGameEvaluator;
import com.oc.cardgame.view.GameSwingPassingView;
import com.oc.cardgame.view.GameSwingView;
import com.oc.cardgame.view.GameViewables;

public class Games {
  public static void main(String[] args) {

    // GameViewables views = new GameViewables();

    GameSwingView gsv = new GameSwingView();
    gsv.createAndShowGUI();

    // Observable pattern
    // views.addViewable(gsv);

    // for (int i = 0; i < 3; i++) {
    //   GameSwingPassingView passiveView = new GameSwingPassingView();
    //   passiveView.createAndShowGUI();
      
    //   views.addViewable(passiveView);

    //   try {
    //     Thread.sleep(2500);
    //   } catch (InterruptedException e) {
    //     e.printStackTrace();
    //   }
    // }

    GameController gc = new GameController(gsv, DeckFactory.makeDeck(DeckType.Normal), new HighCardGameEvaluator());
    gc.run();
  }
}
