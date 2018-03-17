package org.jebtk.ui.fx;

import java.util.concurrent.Callable;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.scene.paint.Color;

public class FxUtils {
  private FxUtils() {

  }

  public static StringBinding cssColorBinding(final String css,
      final ObjectProperty<Color> color) {
    return Bindings.createStringBinding(new Callable<String>() {
      @Override
      public String call() throws Exception {
        return String.format(css + ": rgb(%d, %d, %d);",
            (int) (256 * color.get().getRed()),
            (int) (256 * color.get().getGreen()),
            (int) (256 * color.get().getBlue()));
      }
    }, color);
  }

  public static StringBinding cssFillColorBinding(
      final ObjectProperty<Color> color) {
    return cssColorBinding("-fx-background-color", color);
  }

  public static StringBinding cssBorderColorBinding(
      final ObjectProperty<Color> color) {
    return cssColorBinding("-fx-border-color", color);
  }

  public static java.awt.Color convert(Color color) {
    return new java.awt.Color((float) color.getRed(), (float) color.getGreen(),
        (float) color.getBlue(), (float) color.getOpacity());
  }

  public static Color convert(java.awt.Color color) {
    return new Color(color.getRed() / 255.0, color.getGreen() / 255.0,
        color.getBlue() / 255.0, color.getAlpha() / 255.0);
  }
}
