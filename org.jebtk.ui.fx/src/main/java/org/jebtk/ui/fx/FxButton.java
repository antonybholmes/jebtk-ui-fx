package org.jebtk.ui.fx;

import org.jebtk.modern.UI;
import org.jebtk.modern.event.ModernClickEvent;
import org.jebtk.modern.event.ModernClickEventProducer;
import org.jebtk.modern.event.ModernClickListener;
import org.jebtk.modern.event.ModernClickListeners;

import javafx.scene.control.Button;

public class FxButton extends Button implements ModernClickEventProducer {
  private ModernClickListeners mActionListeners = new ModernClickListeners();
  private String mMessage = UI.ACTION_ASSET_CLICKED;

  public FxButton(String text) {
    super(text);

    getStylesheets().clear();
    
    getStyleClass().add("button");
    
    setOnAction(e -> {fireClicked();});
  }
  
  public String getClickMessage() {
    return mMessage;
  }

  /**
   * Sets the message that will be sent when the item is clicked.
   *
   * @param clickMessage the new click message
   */
  public void setClickMessage(String clickMessage) {
    mMessage  = clickMessage;
  }

  @Override
  public void addClickListener(ModernClickListener l) {
    mActionListeners.addClickListener(l);
  }

  @Override
  public void removeClickListener(ModernClickListener l) {
    mActionListeners.removeClickListener(l);
  }

  @Override
  public void fireClicked(ModernClickEvent e) {
    mActionListeners.fireClicked(e);
  }
  
  public void fireClicked() {
    // setHighlighted(false);

    fireClicked(mMessage);
  }

  /**
   * Sends a message.
   *
   * @param clickMessage the click message
   */
  public void fireClicked(String clickMessage) {
    fireClicked(new ModernClickEvent(this, clickMessage));
  }
}
