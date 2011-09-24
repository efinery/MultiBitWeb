package org.multibit.web.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import org.multibit.web.client.dialog.AboutDialogBox;
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
  }
}
