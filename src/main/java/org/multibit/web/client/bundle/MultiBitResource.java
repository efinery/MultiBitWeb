package org.multibit.web.client.bundle;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * <p>Interface to provide the following to UI components:<br>
 * <ul>
 * <li>Access to known resources</li>
 * </ul>
 * </p>
 * TODO Consider using an enum instead  
 */
public interface MultiBitResource extends ClientBundle {

  public static final MultiBitResource INSTANCE = GWT.create(MultiBitResource.class);

  @ClientBundle.Source("send-big.jpg")
  public ImageResource sendBig();
}
