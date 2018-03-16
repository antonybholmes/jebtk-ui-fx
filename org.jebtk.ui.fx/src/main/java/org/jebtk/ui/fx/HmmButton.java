package org.jebtk.ui.fx;

import org.jebtk.modern.dialog.PrimaryDialogButtonAnimation;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HmmButton extends Button {
  private static final Color OUTLINE_COLOR_1 = FxUtils.convert(PrimaryDialogButtonAnimation.OUTLINE_COLOR_1); //Color.web("#e08090");
  private static final Color OUTLINE_COLOR_2 = FxUtils.convert(PrimaryDialogButtonAnimation.OUTLINE_COLOR_2);
  private static final Color FILL_COLOR_1 = FxUtils.convert(PrimaryDialogButtonAnimation.FILL_1); //Color.web("#e08090");
  private static final Color FILL_COLOR_2 = FxUtils.convert(PrimaryDialogButtonAnimation.FILL_2);
  
  public HmmButton(String text) {
    super(text);

    
    final ObjectProperty<Color> fillColor = new SimpleObjectProperty<Color>(FILL_COLOR_1);
    final ObjectProperty<Color> outlineColor = new SimpleObjectProperty<Color>(OUTLINE_COLOR_1);

    // String that represents the color above as a JavaFX CSS function:
    // -fx-body-color: rgb(r, g, b);
    // with r, g, b integers between 0 and 255
    styleProperty().bind(FxUtils.cssFillColorBinding(fillColor));
    styleProperty().bind(FxUtils.cssBorderColorBinding(outlineColor));

    setOnMouseEntered(e -> {

      Timeline fillTimeline = new Timeline(
          new KeyFrame(Duration.ZERO, new KeyValue(fillColor, FILL_COLOR_1, Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.millis(200), new KeyValue(fillColor, FILL_COLOR_2, Interpolator.EASE_BOTH)));
      
      Timeline outlineTimeline = new Timeline(
          new KeyFrame(Duration.ZERO, new KeyValue(outlineColor, OUTLINE_COLOR_1, Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.millis(200), new KeyValue(outlineColor, OUTLINE_COLOR_2, Interpolator.EASE_BOTH)));

      
      fillTimeline.setCycleCount(1);
      fillTimeline.setAutoReverse(false);
      //timeline.play();

      ParallelTransition parallelTransition = new ParallelTransition();
      parallelTransition.getChildren().addAll(fillTimeline);     
      parallelTransition.play();
    });

    setOnMouseExited(e -> {

      Timeline fillTimeline = new Timeline(
          new KeyFrame(Duration.ZERO, new KeyValue(fillColor, FILL_COLOR_2, Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.millis(200), new KeyValue(fillColor, FILL_COLOR_1, Interpolator.EASE_BOTH)));
      
      Timeline outlineTimeline = new Timeline(
          new KeyFrame(Duration.ZERO, new KeyValue(outlineColor, OUTLINE_COLOR_2, Interpolator.EASE_BOTH)),
          new KeyFrame(Duration.millis(200), new KeyValue(outlineColor, OUTLINE_COLOR_1, Interpolator.EASE_BOTH)));

      
      fillTimeline.setCycleCount(1);
      fillTimeline.setAutoReverse(false);
      //timeline.play();

      ParallelTransition parallelTransition = new ParallelTransition();
      parallelTransition.getChildren().addAll(fillTimeline);     
      parallelTransition.play();

    });
  }
}
