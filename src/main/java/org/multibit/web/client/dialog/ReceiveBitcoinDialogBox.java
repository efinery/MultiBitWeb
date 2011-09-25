package org.multibit.web.client.dialog;

import com.google.gwt.user.client.ui.*;
import org.multibit.web.client.bundle.MultiBitResource;

/**
 * <p>DialogBox to provide the following to Presenter:<br>
 * <ul>
 * <li>Limited access to UI components</li>
 * </ul>
 * </p>
 */
public class ReceiveBitcoinDialogBox extends DialogBox {

  private Button addressBookButton;
  private Button cancelButton;
  private Button copyAddressButton;
  private Button createNewButton;
  private Button receiveButton;
  private Label addressLabel;
  private TextBox addressTextBox;
  private Label labelLabel;
  private TextBox labelTextBox;
  private Image sendBitcoinImage;

  /**
   * Cannot create this directly - use newInstance()
   */
  private ReceiveBitcoinDialogBox() {
  }

  public static ReceiveBitcoinDialogBox newInstance() {

    // Create the general structure
    final ReceiveBitcoinDialogBox dialogBox = new ReceiveBitcoinDialogBox();

    dialogBox.setVisible(false);
    dialogBox.setText("Receive Bitcoin");
    dialogBox.setAnimationEnabled(true);
    // Append this style to ensure standard GWT styling is maintained
    dialogBox.setStyleName("receiveBitcoinDialogBox",true);

    // Configure the controls to allow external access
    dialogBox.setSendBitcoinImage(new Image(MultiBitResource.INSTANCE.receiveBitcoinBig()));
    dialogBox.setAddressLabel(new Label("Address"));
    dialogBox.setLabelLabel(new Label("Label"));
    dialogBox.setAddressBookButton(new Button("Address Book"));
    dialogBox.setAddressTextBox(new TextBox());
    dialogBox.setLabelTextBox(new TextBox());
    dialogBox.setCancelButton(new Button("Cancel"));
    dialogBox.setReceiveButton(new Button("OK"));
    dialogBox.setCopyAddressButton(new Button("Copy Address"));
    dialogBox.setCreateNewButton(new Button("Create New..."));

    // Require complex positioning
    FlexTable panel = new FlexTable();

    // Row 0
    panel.setWidget(0,0,dialogBox.getSendBitcoinImage());
    panel.setHTML(0, 1, "Give your receiving address below to the person sending you bitcoins.");

    // Row 1 Address (wide)
    panel.setWidget(1, 0, dialogBox.getAddressLabel());
    panel.setWidget(1, 1, dialogBox.getAddressTextBox());
    panel.setWidget(1, 2, dialogBox.getAddressBookButton());

    // Row 2 Label
    panel.setWidget(2, 0, dialogBox.getLabelLabel());
    panel.setWidget(2, 1, dialogBox.getLabelTextBox());

    // Row 3 Buttons
    panel.setWidget(3, 1, dialogBox.getCancelButton());
    panel.setWidget(3, 2, dialogBox.getCopyAddressButton());
    panel.setWidget(3, 3, dialogBox.getCreateNewButton());
    panel.setWidget(3, 4,dialogBox.getReceiveButton());

    // CSS styling

    // Adjust the column width using it's formatter
    HTMLTable.ColumnFormatter formatter = panel.getColumnFormatter();
    formatter.setStyleName(1,"sendBitcoinDialogBox-wide");

    dialogBox.getAddressTextBox().setStyleName("sendBitcoinDialogBox-wide");
    dialogBox.getLabelTextBox().setStyleName("sendBitcoinDialogBox-wide");

    // Bind it to the dialog
    dialogBox.setWidget(panel);

    return dialogBox;
  }

  public Button getAddressBookButton() {
    return addressBookButton;
  }

  protected void setAddressBookButton(Button addressBookButton) {
    this.addressBookButton = addressBookButton;
  }

  public Button getCancelButton() {
    return cancelButton;
  }

  protected void setCancelButton(Button cancelButton) {
    this.cancelButton = cancelButton;
  }

  public Button getReceiveButton() {
    return receiveButton;
  }

  protected void setReceiveButton(Button receiveButton) {
    this.receiveButton = receiveButton;
  }

  public Label getAddressLabel() {
    return addressLabel;
  }

  protected void setAddressLabel(Label addressLabel) {
    this.addressLabel = addressLabel;
  }

  public Label getLabelLabel() {
    return labelLabel;
  }

  protected void setLabelLabel(Label labelLabel) {
    this.labelLabel = labelLabel;
  }

  public Image getSendBitcoinImage() {
    return sendBitcoinImage;
  }

  protected void setSendBitcoinImage(Image sendBitcoinImage) {
    this.sendBitcoinImage = sendBitcoinImage;
  }

  public TextBox getAddressTextBox() {
    return addressTextBox;
  }

  protected void setAddressTextBox(TextBox addressTextBox) {
    this.addressTextBox = addressTextBox;
  }

  public TextBox getLabelTextBox() {
    return labelTextBox;
  }

  protected void setLabelTextBox(TextBox labelTextBox) {
    this.labelTextBox = labelTextBox;
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
}
