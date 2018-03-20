package org.jebtk.ui.fx;

import org.jebtk.core.settings.SettingsService;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class FxScene extends Scene {
  
  public static final String ASSET_ROBOTO_FONT_URL = 
      SettingsService.getInstance().getAsString("fx.fonts.font-url");

  public FxScene(Parent root, double width, double height) {
    super(root, width, height);
    
    setCSS();
  }

  public void setCSS() {
    getStylesheets().clear();
    getStylesheets().add(getClass().getClassLoader().getResource("css/app.css").toExternalForm());
    getStylesheets().add(ASSET_ROBOTO_FONT_URL);
  }
}
