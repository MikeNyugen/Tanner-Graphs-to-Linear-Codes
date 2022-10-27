package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * Responsible for displaying the message node correctly.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class MessageNode extends AnchorPane {
  @FXML
  MessageNodeController messageNodeController;

  public MessageNode() throws IOException {
    super();
    fxmlSetup();
    makeDraggable(this);
  }

  /**
   * Sets up the FXML for the message node.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  private void fxmlSetup() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
          "/com/mikenyugen/linearcodes/MessageNode.fxml"));
      Node node = fxmlLoader.load();
      this.getChildren().add(node);
    } catch (IOException e) {
      throw new IOException("FXML loader failure");
    }
  }



}
