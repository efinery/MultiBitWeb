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
public class SendBitcoinDialogBox extends DialogBox {

  private Button pasteButton;
  private Button addressBookButton;
  private Button cancelButton;
  private Button sendButton;
  private Label addressLabel;
  private TextBox addressTextBox;
  private Label labelLabel;
  private TextBox labelTextBox;
  private Label amountLabel;
  private TextBox amountTextBox;
  private Label denominationLabel;
  private Image sendBitcoinImage;

  /**
   * Cannot create this directly - use newInstance()
   */
  private SendBitcoinDialogBox() {
  }

  public static SendBitcoinDialogBox newInstance() {

    // Create the general structure
    final SendBitcoinDialogBox dialogBox = new SendBitcoinDialogBox();

    dialogBox.setVisible(false);
    dialogBox.setText("Send Bitcoin");
    dialogBox.setAnimationEnabled(true);
    // Append this style to ensure standard GWT styling is maintained
    dialogBox.setStyleName("sendBitcoinDialogBox",true);

    // Configure the controls to allow external access
    dialogBox.setSendBitcoinImage(new Image(MultiBitResource.INSTANCE.sendBig()));
    dialogBox.setAddressLabel(new Label("Address"));
    dialogBox.setLabelLabel(new Label("Label"));
    dialogBox.setAmountLabel(new Label("Amount"));
    dialogBox.setPasteButton(new Button("Paste"));
    dialogBox.setAddressBookButton(new Button("Address Book"));
    dialogBox.setDenominationLabel(new Label("BTC"));
    dialogBox.setAddressTextBox(new TextBox());
    dialogBox.setLabelTextBox(new TextBox());
    dialogBox.setAmountTextBox(new TextBox());
    dialogBox.setCancelButton(new Button("Cancel"));
    dialogBox.setSendButton(new Button("Send"));

    // Dialog contains a vertical panel widget for content
    FlexTable panel = new FlexTable();

    // Panel is 4x7 to allow for variable column width presentation
    // Row 0
    panel.setWidget(0,0,dialogBox.getSendBitcoinImage());
    panel.setHTML(0, 1, "Enter the address you want to send bitcoins to and the amount to send.<br>Optionally add a descriptive label for the address.");

    // Row 1 Address (wide)
    panel.setWidget(1, 0, dialogBox.getAddressLabel());
    panel.setWidget(1, 1, dialogBox.getAddressTextBox());
    panel.setWidget(1, 2, dialogBox.getPasteButton());
    panel.setWidget(1, 3, dialogBox.getAddressBookButton());

    // Row 2 Label
    panel.setWidget(2, 0, dialogBox.getLabelLabel());
    panel.setWidget(2, 1, dialogBox.getLabelTextBox());

    // Row 3 Amount
    panel.setWidget(3, 0, dialogBox.getAmountLabel());
    panel.setWidget(3, 1, dialogBox.getAmountTextBox());
    panel.setWidget(3, 2, dialogBox.getDenominationLabel());

    // Row 4 Buttons
    panel.setWidget(4, 3, dialogBox.getCancelButton());
    panel.setWidget(4, 4,dialogBox.getSendButton());

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

  public Button getPasteButton() {
    return pasteButton;
  }

  protected void setPasteButton(Button pasteButton) {
    this.pasteButton = pasteButton;
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

  public Button getSendButton() {
    return sendButton;
  }

  protected void setSendButton(Button sendButton) {
    this.sendButton = sendButton;
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

  public Label getAmountLabel() {
    return amountLabel;
  }

  protected void setAmountLabel(Label amountLabel) {
    this.amountLabel = amountLabel;
  }

  public Label getDenominationLabel() {
    return denominationLabel;
  }

  protected void setDenominationLabel(Label denominationLabel) {
    this.denominationLabel = denominationLabel;
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

  public TextBox getAmountTextBox() {
    return amountTextBox;
  }

  protected void setAmountTextBox(TextBox amountTextBox) {
    this.amountTextBox = amountTextBox;
  }
}
