package org.multibit.web.client;

import com.google.gwt.user.client.Command;

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
    // TODO Insert something
  }
}
