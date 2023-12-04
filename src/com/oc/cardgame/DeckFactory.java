package com.oc.cardgame;

import com.oc.cardgame.model.Deck;
import com.oc.cardgame.model.NormalDeck;
import com.oc.cardgame.model.SmallDeck;
import com.oc.cardgame.model.TestDeck;

public class DeckFactory {
  public enum DeckType {
    Normal,
    Small,
    Test
  }

  public static Deck makeDeck(DeckType type) {
    switch (type) {
      case Normal:
        return new NormalDeck();
      case Small:
        return new SmallDeck();
      case Test:
        return new TestDeck();
    }

    return new NormalDeck();
  }
}
