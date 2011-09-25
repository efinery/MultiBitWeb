package org.multibit.web.client.dialog;

import com.google.gwt.user.client.ui.*;

/**
 * <p>DialogBox to provide the following to Presenter:<br>
 * <ul>
 * <li>Limited access to UI components</li>
 * </ul>
 * </p>
 */
public class AddressBookDialogBox extends DialogBox {

  private Grid receivingAddressGrid;
  private Grid sendingAddressGrid;

  private Button cancelButton;
  private Button okButton;
  private Button copyAddressButton;
  private Button createNewButton;

  /**
   * Cannot create this directly - use newInstance()
   */
  private AddressBookDialogBox() {
  }

  public static AddressBookDialogBox newInstance() {

    // Create the general structure
    final AddressBookDialogBox dialogBox = new AddressBookDialogBox();

    dialogBox.setVisible(false);
    dialogBox.setText("Address Book");
    dialogBox.setAnimationEnabled(true);
    // Append this style to ensure standard GWT styling is maintained
    dialogBox.setStyleName("addressBookDialogBox",true);

    // Configure the controls to allow external access
    dialogBox.setReceivingAddressGrid(new Grid(10, 2));
    dialogBox.setSendingAddressGrid(new Grid(5, 2));
    dialogBox.setCancelButton(new Button("Cancel"));
    dialogBox.setCopyAddressButton(new Button("Copy Address"));
    dialogBox.setCreateNewButton(new Button("Create New..."));
    dialogBox.setOkButton(new Button("Ok"));

    // Use combination of outer vertical panel
    // with additional widgets contained within
    VerticalPanel panel = new VerticalPanel();

    // Dialog contains a tab panel widget for content
    TabPanel tabPanel = new TabPanel();
    panel.add(tabPanel);
    // Configure receiving addresses grid
    tabPanel.add(dialogBox.getReceivingAddressGrid(),"Your Receiving Addresses");
    dialogBox.getReceivingAddressGrid().setText(0, 0, "Label");
    dialogBox.getReceivingAddressGrid().setText(0,1,"Address");
    // TODO Link to the server to get data
    for (int row=1; row<10; row++) {
      dialogBox.getReceivingAddressGrid().setText(row, 0, "Received "+row);
      dialogBox.getReceivingAddressGrid().setText(row, 1, "Address "+row);
    }

    // Configure sending addresses grid
    tabPanel.add(dialogBox.getSendingAddressGrid(),"Your Sending Addresses");
    dialogBox.getSendingAddressGrid().setText(0,0,"Label");
    dialogBox.getSendingAddressGrid().setText(0,1,"Address");
    // TODO Link to the server to get data
    for (int row=1; row<5; row++) {
      dialogBox.getSendingAddressGrid().setText(row, 0, "Sent "+row);
      dialogBox.getSendingAddressGrid().setText(row, 1, "Address "+row);
    }

    // Initialise tabs (no events needed)
    tabPanel.selectTab(0);
    dialogBox.getReceivingAddressGrid().setVisible(true);

    // Configure buttons within a horizontal panel
    HorizontalPanel horizontalPanel = new HorizontalPanel();
    panel.add(horizontalPanel);
    horizontalPanel.add(dialogBox.getCancelButton());
    horizontalPanel.add(dialogBox.getCopyAddressButton());
    horizontalPanel.add(dialogBox.getCreateNewButton());
    horizontalPanel.add(dialogBox.getOkButton());

    // Bind it to the dialog
    dialogBox.setWidget(panel);

    return dialogBox;
  }

  public Button getCancelButton() {
    return cancelButton;
  }

  protected void setCancelButton(Button cancelButton) {
    this.cancelButton = cancelButton;
  }

  public Button getOkButton() {
    return okButton;
  }

  protected void setOkButton(Button okButton) {
    this.okButton = okButton;
  }

  public Button getCopyAddressButton() {
    return copyAddressButton;
  }

  protected void setCopyAddressButton(Button copyAddressButton) {
    this.copyAddressButton = copyAddressButton;
  }

  public Button getCreateNewButton() {
    return createNewButton;
  }

  protected void setCreateNewButton(Button createNewButton) {
    this.createNewButton = createNewButton;
  }

  public Grid getReceivingAddressGrid() {
    return receivingAddressGrid;
  }

  protected void setReceivingAddressGrid(Grid receivingAddressGrid) {
    this.receivingAddressGrid = receivingAddressGrid;
  }

  public Grid getSendingAddressGrid() {
    return sendingAddressGrid;
  }

  protected void setSendingAddressGrid(Grid sendingAddressGrid) {
    this.sendingAddressGrid = sendingAddressGrid;
  }
}
