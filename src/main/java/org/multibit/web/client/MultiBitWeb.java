package org.multibit.web.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;
import org.multibit.web.client.bundle.MultiBitResource;
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
    RootPanel.get().clear();

    RootPanel.get().add(buildTopMenu());
    RootPanel.get().add(buildCommandBar());
    RootPanel.get().add(buildTransactionGrid());
  }

  /**
   * @return The MenuBar for the top line
   */
  private MenuBar buildTopMenu() {

    // Create a menu structure using a code generator
    MenuMaker menuMaker = GWT.create(MenuMaker.class);
    return menuMaker.createMenu();

  }

  /**
   *
   * @return The Widget holding the command
   */
  private Widget buildCommandBar() {
    HorizontalPanel panel = new HorizontalPanel();
    panel.setSpacing(10);
    panel.setStyleName("commandBar");

    // Open wallet
    ImageButton openWalletButton = new ImageButton("Open Wallet",MultiBitResource.INSTANCE.openWallet());
    panel.add(openWalletButton);
    openWalletButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        (new HistoryCommand("OPEN_WALLET")).execute();
      }
    });
    
    // Receive Bitcoin
    ImageButton receiveBitcoinButton = new ImageButton("Receive Bitcoin",MultiBitResource.INSTANCE.receiveBitcoin());
    panel.add(receiveBitcoinButton);
    receiveBitcoinButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        (new HistoryCommand("RECEIVE_BITCOIN")).execute();
      }
    });

    // Send Bitcoin
    ImageButton sendBitcoinButton = new ImageButton("Send Bitcoin",MultiBitResource.INSTANCE.sendBitcoin());
    panel.add(sendBitcoinButton);
    sendBitcoinButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        (new HistoryCommand("SEND_BITCOIN")).execute();
      }
    });

    // Address book
    ImageButton addressBookButton = new ImageButton("Address Book",MultiBitResource.INSTANCE.addressBook());
    panel.add(addressBookButton);
    addressBookButton.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        (new HistoryCommand("ADDRESS_BOOK")).execute();
      }
    });

    // Balance
    Label balanceLabel = new Label("Balance");
    panel.add(balanceLabel);

    // Balance amount
    Label balanceAmountLabel = new Label("0.00 BTC");
    panel.add(balanceAmountLabel);

    return panel;
  }

  private Widget buildTransactionGrid() {

    Grid transactionGrid = new Grid(25,5);
    transactionGrid.setStyleName("transactionGrid");
    transactionGrid.setText(0,0,"Status");
    transactionGrid.setText(0,1,"Date");
    transactionGrid.setText(0,2,"Description");
    transactionGrid.setText(0,3,"Debit");
    transactionGrid.setText(0,4,"Credit");

    // Create some fake transactions
    for (int row=1; row<9; row++) {
      transactionGrid.setWidget(row,0,new Image(MultiBitResource.INSTANCE.tick()));
      transactionGrid.setText(row,1,row+" Sep 2011 15:1"+row);
      transactionGrid.setText(row,2,"Received with \"example"+row+"\" (1Exm1UyTGLqTPbWbgeopmftEtNUIUe)");
      transactionGrid.setText(row,4,row*15+".0250");
    }

    // Apply CSS formatting
    transactionGrid.getRowFormatter().addStyleName(0,"transactionGrid-header");


    return transactionGrid;
  }

}
