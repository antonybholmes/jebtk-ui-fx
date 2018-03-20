package org.jebtk.ui.fx;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class Card extends BorderPane {
  public Card() {
    setCss();
  }
  
  public Card(Pane pane) {
    this();
    
    setCenter(pane);
  }

  private void setCss() {
    getStylesheets().clear();
    getStyleClass().add("card");
  }
}
