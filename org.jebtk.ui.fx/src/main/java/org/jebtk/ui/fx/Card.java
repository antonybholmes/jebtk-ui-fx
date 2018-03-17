package org.jebtk.ui.fx;

import javafx.scene.layout.BorderPane;

public class Card extends BorderPane {
  public Card() {
    getStylesheets().clear();
    getStyleClass().add("card");
  }
}
