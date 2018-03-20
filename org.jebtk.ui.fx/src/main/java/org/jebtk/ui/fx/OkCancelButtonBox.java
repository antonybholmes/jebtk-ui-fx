package org.jebtk.ui.fx;

import javafx.scene.control.Button;

public class OkCancelButtonBox extends ButtonBox {

  private Button mOkButton = new FxPrimaryDialogButton("OK");
  private Button mCancelButton = new FxDialogButton("Cancel");
  
  public OkCancelButtonBox() {
    add(mOkButton, mCancelButton);
  }
}
