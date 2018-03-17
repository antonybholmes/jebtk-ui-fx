package org.jebtk.ui.fx;

import javax.swing.SwingUtilities;

import org.jebtk.modern.button.ModernButton;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ButtonExperiments extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    SwingNode swingNode = new SwingNode();

    createSwingContent(swingNode);

    primaryStage.setTitle("Button Experiment 1");

    // Button button1 = new Button("Button 1");
    Button button2 = new HmmButton("Button 2");
    // Button button3 = new Button("Button 3");
    // Button button4 = new Button("Button 4");

    // .getStyleClass().add("button1");
    // button2.setStyle("-fx-background-color: #00ff00");
    // button3.setStyle("-fx-font-size: 2em; ");
    // button4.setStyle("-fx-text-fill: #0000ff");

    //HBox hbox = new HBox(button2);

    BorderPane borderPane = new Card();

    borderPane.setLeft(swingNode);
    borderPane.setRight(button2);

    Scene scene = new Scene(borderPane, 400, 400);
    String css = getClass().getClassLoader().getResource("css/style.css")
        .toExternalForm();
    scene.getStylesheets().clear();
    scene.getStylesheets().add(css);
    primaryStage.setScene(scene);
    primaryStage.show();
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
    Application.launch(args);
  }
}