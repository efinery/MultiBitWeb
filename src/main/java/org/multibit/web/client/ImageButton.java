package org.multibit.web.client;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;

/**
 * <p>Button to provide the following to client UI:<br>
 * <ul>
 * <li>A button providing both an image and text</li>
 * </ul>
 * </p>
 *  
 */
public class ImageButton extends Button {

  private String text;

  public ImageButton() {
    super();
  }


  public ImageButton(String text, ImageResource imageResource) {
    setText(text);
    setImageResource(imageResource);
  }

  public void setImageResource(ImageResource imageResource){
    Image img = new Image(imageResource);
    String definedStyles = img.getElement().getAttribute("style");
    img.getElement().setAttribute("style", definedStyles + "; vertical-align:middle;");
    DOM.insertBefore(getElement(), img.getElement(), DOM.getFirstChild(getElement()));
   }

   @Override
   public void setText(String text) {
    this.text = text;
    Element span = DOM.createElement("span");
    span.setInnerText(text);
    span.setAttribute("style", "padding-left:3px; vertical-align:middle;");

    DOM.insertChild(getElement(), span, 0);
   }

   @Override
   public String getText() {
    return this.text;
   }

}
