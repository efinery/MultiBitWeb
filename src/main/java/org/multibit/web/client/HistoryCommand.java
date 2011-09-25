package org.multibit.web.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.TabPanel;
import org.multibit.web.client.dialog.AboutDialogBox;
import org.multibit.web.client.dialog.AddressBookDialogBox;
import org.multibit.web.client.dialog.ReceiveBitcoinDialogBox;
import org.multibit.web.client.dialog.SendBitcoinDialogBox;

/**
 *  <p>Command to provide the following to application:<br>
 *  <ul>
 *  <li>Provision of History token management</li>
 *  </ul>
 *  </p>
 *  
 */
public class HistoryCommand implements Command {

  String historyToken;

  public HistoryCommand(final String newToken) {
    historyToken = newToken;
  }

  // TODO Refactor this into something that scales better
  @Override
  public void execute() {
    if ("ABOUT".equals(historyToken)) {
      final AboutDialogBox dialogBox = AboutDialogBox.newInstance();
      dialogBox.center();
      dialogBox.getCloseButton().setFocus(true);

      dialogBox.getCloseButton().addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          dialogBox.hide();
        }
      });

    }
    if ("SEND_BITCOIN".equals(historyToken)) {
      final SendBitcoinDialogBox dialogBox = SendBitcoinDialogBox.newInstance();
      dialogBox.center();
      dialogBox.getCancelButton().setFocus(true);

      dialogBox.getCancelButton().addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          dialogBox.hide();
        }
      });

    }
    if ("RECEIVE_BITCOIN".equals(historyToken)) {
      final ReceiveBitcoinDialogBox dialogBox = ReceiveBitcoinDialogBox.newInstance();
      dialogBox.center();
      dialogBox.getCancelButton().setFocus(true);

      dialogBox.getCancelButton().addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          dialogBox.hide();
        }
      });

    }
    if ("ADDRESS_BOOK".equals(historyToken)) {
      final AddressBookDialogBox dialogBox = AddressBookDialogBox.newInstance();
      dialogBox.center();
      dialogBox.getCancelButton().setFocus(true);

      // Cancel
      dialogBox.getCancelButton().addClickHandler(new ClickHandler() {
        @Override
        public void onClick(ClickEvent event) {
          dialogBox.hide();
        }
      });

      // Tab change
      TabPanel panel = (TabPanel) dialogBox.getWidget();
      panel.addSelectionHandler(new SelectionHandler<Integer>() {
        @Override
        public void onSelection(SelectionEvent<Integer> tabIndex) {
          if (tabIndex.getSelectedItem()==0) {
            // Receiving addresses
            dialogBox.getSendingAddressGrid().setVisible(false);
            dialogBox.getReceivingAddressGrid().setVisible(true);
          }
          if (tabIndex.getSelectedItem()==1) {
            // Sending addresses
            dialogBox.getSendingAddressGrid().setVisible(true);
            dialogBox.getReceivingAddressGrid().setVisible(false);
          }
        }
      });
    }
  }
}
