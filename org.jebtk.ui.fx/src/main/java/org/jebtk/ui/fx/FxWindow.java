package org.jebtk.ui.fx;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import org.jebtk.modern.button.ModernButton;
import org.jebtk.modern.help.GuiAppInfo;

import javafx.embed.swing.SwingNode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FxWindow extends Stage {
  private Pane mRootPane = new StackPane();
  private BorderPane mContentPane = new BorderPane();
  private Pane mPopupPane = new FxPopupPane();
  private FxScene mScene;
  private GuiAppInfo mAppInfo;
  private String mSubTitle;
  
  public FxWindow(String title) {
    this(title, 640, 480);
  }
  
  public FxWindow(String title, int w, int h) {
    setTitle(title);
    
    mScene = new FxScene(mRootPane, w, h);
    
    setScene(mScene);
    
    getRootPane().getChildren().add(mContentPane);
    getRootPane().getChildren().add(mPopupPane);

    setOnCloseRequest(e -> {windowClosing(e);});
  }
  
  public FxWindow(String title, Pane pane) {
    this(title, pane, 640, 480);
  }
  
  public FxWindow(String title, Pane pane, int w, int h) {
    this(title, w, h);
    
    setContent(pane);
  }
  
  public FxWindow(GuiAppInfo appInfo) {
    // TODO Auto-generated constructor stub
  }
  
  public void setAppInfo(GuiAppInfo appInfo) {
    mAppInfo = appInfo;
    setTitle(getAppInfo().getName());
  }
  
  public GuiAppInfo getAppInfo() {
    return mAppInfo;
  }
  
  /**
   * Set the window title but include the main app title.
   *
   * @param subTitle the new sub title
   */
  public void setSubTitle(String subTitle) {
    setTitle(subTitle + " - " + getAppInfo().getName());

    mSubTitle = subTitle;
  }

  /**
   * Gets the sub title.
   *
   * @return the sub title
   */
  public String getSubTitle() {
    return mSubTitle;
  }

  public void setCard(Pane pane) {
    setContent(new Card(pane));
  }

  private void setContent(Pane pane) {
    mContentPane.setCenter(pane);
  }
  
  public Pane getRootPane() {
    return mRootPane;
  }
  
  public Pane getContentPane() {
    return mContentPane;
  }
  
  public void windowClosing(WindowEvent e) {
    System.out.println("Window is closing");
    
    close();
  }

  public void setHeader(final JComponent c) {
    setTop(c);
  }
  
  public void setTop(final JComponent c) {
    
    SwingNode swingNode = new SwingNode();
    
    ((BorderPane)getContentPane()).setTop(swingNode);
    
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        swingNode.setContent(c);
      }
    });
  }
  
  public void setFooter(final JComponent c) {
    setBottom(c);
  }
  
  public void setBottom(final JComponent c) {
    
    SwingNode swingNode = new SwingNode();
    
    ((BorderPane)getContentPane()).setBottom(swingNode);
    
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        swingNode.setContent(c);
      }
    });
  }
}
