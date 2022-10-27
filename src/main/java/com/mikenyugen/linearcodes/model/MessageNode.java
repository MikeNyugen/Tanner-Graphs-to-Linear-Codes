package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.controllers.MessageNodeController;
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
  MessageNodeController controller;

  public MessageNode() throws IOException {
    super();
    fxmlSetup();
  }

  /**
   * Sets up the FXML for the message node.
   *
   * @throws IOException if the fxml cannot be loaded
   */
  private void fxmlSetup() throws IOException {
    try {
      // Load FXML
      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "/com/mikenyugen/linearcodes/MessageNode.fxml"));
      // Bind to controller
      controller = new MessageNodeController();
      loader.setController(controller);
      // Make the node draggable
      makeDraggable(this);
      // Make node visible
      Node node = loader.load();
      this.getChildren().add(node);
    } catch (IOException e) {
      throw new IOException("FXML loader failure");
    }
  }

}
