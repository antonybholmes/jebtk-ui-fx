package org.jebtk.ui.fx;

import javax.swing.SwingUtilities;

import org.jebtk.core.AppService;
import org.jebtk.modern.ColorTheme;
import org.jebtk.modern.button.ModernButton;
import org.jebtk.modern.theme.ThemeService;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FxApplication extends Application {
  
  
  @Override
  public void start(Stage stage) throws Exception {
    AppService.getInstance().setAppInfo("fx");

    ThemeService.getInstance().setTheme(ColorTheme.BLUE);
    
    SwingNode swingNode = new SwingNode();

    createSwingContent(swingNode);

    // Button button1 = new Button("Button 1");
    //Button button2 = new FxPrimaryDialogButton("Button 2");
    //Button button3 = new FxPrimaryDialogButton("Button 3");
    // Button button3 = new Button("Button 3");
    // Button button4 = new Button("Button 4");

    // .getStyleClass().add("button1");
    // button2.setStyle("-fx-background-color: #00ff00");
    // button3.setStyle("-fx-font-size: 2em; ");
    // button4.setStyle("-fx-text-fill: #0000ff");

    //HBox hbox = new HBox(button2);

    BorderPane borderPane = new BorderPane();

    borderPane.setLeft(swingNode);
    borderPane.setBottom(new OkCancelButtonBox());

    FxWindow window = new FxWindow("Aha");
    
    window.setCard(borderPane);

    window.show();
  }

  @Override
  public void stop() {
    //System.out.println("Stage is closing");
    // Save file
  }

  private void createSwingContent(final SwingNode swingNode) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        swingNode.setContent(new ModernButton("Click me!"));
      }
    });
  }

  public static void main(String[] args) {
    launch(args);
  }
}