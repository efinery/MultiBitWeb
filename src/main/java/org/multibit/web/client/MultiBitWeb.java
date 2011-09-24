package org.multibit.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import org.multibit.web.client.menu.MenuMaker;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MultiBitWeb implements EntryPoint {

  private String startingToken = "";

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    buildMainMenu();

  }

  private void buildMainMenu() {

    // Create a menu structure using a code generator
    MenuMaker menuMaker = GWT.create(MenuMaker.class);

    MenuBar menuBar = menuMaker.createMenu();

    RootPanel.get().clear();
    RootPanel.get().add(menuBar);

  }
}
