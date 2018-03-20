/**
 * Copyright (C) 2016, Antony Holmes
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. Neither the name of copyright holder nor the names of its contributors 
 *     may be used to endorse or promote products derived from this software 
 *     without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jebtk.ui.fx;

import java.awt.Component;

import org.jebtk.modern.contentpane.ModernHContentPane;
import org.jebtk.modern.help.GuiAppInfo;
import org.jebtk.modern.panel.CardPanel;
import org.jebtk.modern.ribbon.Ribbon;
import org.jebtk.modern.shadow.TopShadowPanel;
import org.jebtk.modern.status.ModernStatusBar;
import org.jebtk.modern.widget.ModernClickWidget;
import org.jebtk.modern.widget.ModernWidget;
import org.jebtk.modern.window.IconTabs;
import org.jebtk.modern.window.ModernTitleBar;
import org.jebtk.modern.window.ModernWindow;

// TODO: Auto-generated Javadoc
/**
 * All windowed apps should inherit from this.
 *
 * @author Antony Holmes Holmes
 */
public class ModernRibbonWindow extends FxWindow {
  /**
   * The member ribbon.
   */
  protected Ribbon mRibbon = null;

  /** The m status bar. */
  protected ModernStatusBar mStatusBar = new ModernStatusBar();

  private IconTabs mIconTabs;
  
  private ModernHContentPane mTabsPane = new ModernHContentPane();

  /**
   * Instantiates a new modern window2.
   *
   * @param appInfo the app info
   */
  public ModernRibbonWindow(GuiAppInfo appInfo) {
    super(appInfo);

    // setGlassPane(mMessagePane);
    mRibbon = new Ribbon(this);
    
    mRibbon.setTitle(getAppInfo().getName());
    
    super.setHeader(mRibbon);

    // getGlassPane().setVisible(true);
    // getGlassPane().addMouseListener(new
    // GlassPaneMouseEvents(getContentPanel(), getGlassPane()));
    // getGlassPane().addMouseMotionListener(new
    // GlassPaneMouseMotionEvents(getContentPanel(), getGlassPane()));

    /*
     * if (UI.CUSTOM_WINDOW_DECORATION) { // Disable chrome
     * setUndecorated(true);
     * 
     * // Add a colored border for aesthetics and to ensure resizing // works
     * from any border location // mContentPanel.setBorder(RIBBON_BORDER); //
     * mRibbonMenu.setBorder(RIBBON_BORDER); mCards.setBorder(RIBBON_BORDER);
     * 
     * new WindowMover(this, mRibbon); new WindowResizer(this); }
     */

    setFooter(mStatusBar);

    setTitle(getTitle());

    mIconTabs = new IconTabs(tabsPane());
  }
  
  public ModernHContentPane tabsPane() {
    return mTabsPane;
  }

  /**
   * Gets the ribbon.
   *
   * @return the ribbon
   */
  public Ribbon getRibbon() {
    return mRibbon;
  }

  /**
   * Gets the status bar.
   *
   * @return the status bar
   */
  public ModernStatusBar getStatusBar() {
    return mStatusBar;
  }

  /**
   * Gets the title bar.
   *
   * @return the title bar
   */
  public ModernTitleBar getTitleBar() {
    return mRibbon.getTitleBar();
  }

  /**
   * Gets the icon tabs pane that sits on the left of the window. This is
   * automatically created if it does not exist.
   * 
   * @return
   */
  public IconTabs getIconTabs() {
    return mIconTabs;
  }

  /**
   * Add a quick access button. Depending on the window decoration this will
   * automatically be either on the left side of the title bar or the ribbon
   * itself.
   *
   * @param button the button
   */
  public void addQuickAccessButton(ModernClickWidget button) {
    // Add the quick access buttons to the title bar rather than the
    // ribbon.

    mRibbon.addQuickAccessButton(button);

    // super.addQuickAccessButton(button);
  }
}
