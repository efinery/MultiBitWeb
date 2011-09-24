package org.multibit.web.client.dialog;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * <p>DialogBox to provide the following to Presenter:<br>
 * <ul>
 * <li>Limited access to UI components</li>
 * </ul>
 * </p>
 */
public class AboutDialogBox extends DialogBox {

  private Button closeButton=null;

  /**
   * Cannot create this directly - use newInstance()
   */
  private AboutDialogBox() {
  }

  public static AboutDialogBox newInstance() {

    // Create the general structure
    final AboutDialogBox dialogBox = new AboutDialogBox();
    dialogBox.setVisible(false);
    dialogBox.setText("About MultiBitWeb");
    dialogBox.setAnimationEnabled(true);

    // Create a close button with a suitable ID for attaching an event handler
    Button closeButton = new Button();
    closeButton.getElement().setId("closeButton");
    dialogBox.setCloseButton(closeButton);

    // Dialog contains a vertical panel widget for content
    VerticalPanel panel = new VerticalPanel();
    panel.addStyleName("dialogVPanel");
    panel.add(new HTML("<b>MultiBitWeb</b>"));
    panel.add(new HTML("<br>A web interface for the MultiBit project"));
    panel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
    panel.add(closeButton);

    // Bind it to the dialog
    dialogBox.setWidget(panel);

    return dialogBox;
  }

  protected void setCloseButton(Button closeButton) {
    this.closeButton=closeButton;
  }

  public Button getCloseButton() {
    return this.closeButton;
  }
}
