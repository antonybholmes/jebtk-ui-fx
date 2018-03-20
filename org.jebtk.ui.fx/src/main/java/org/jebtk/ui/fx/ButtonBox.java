package org.jebtk.ui.fx;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class ButtonBox extends HBox {
  public ButtonBox() {
    Node r = new Region();
    HBox.setHgrow(r, Priority.ALWAYS);
    
    getChildren().add(r);
    
    setSpacing(5);
  }

  public ButtonBox(Node... nodes) {
    this();
    
    for (Node n : nodes) {
      getChildren().add(n);
    }
  }
  
  public void add(Node... nodes) {
    getChildren().addAll(nodes);
  }
}
