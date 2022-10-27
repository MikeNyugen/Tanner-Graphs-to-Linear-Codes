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
 *
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class MessageNode extends AnchorPane {
  @FXML
  MessageNodeController messageNodeController;

  public MessageNode() throws IOException {
    super();
    messageNodeSetup();
    messageNodeController.incrementNodes();
    makeDraggable(this);
  }

  /**
   * Loads FXML and binds the controller.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  private void messageNodeSetup() throws IOException {
    // Load FXML
    FXMLLoader fxmlLoader = fxmlSetup();
    // Bind FXML to controller
    messageNodeController = new MessageNodeController();
    fxmlLoader.setController(messageNodeController);
  }

  /**
   * Sets up the FXML for the message node.
   *
   * @return a FXML loader object
   * @throws IOException if the FXML cannot be loaded
   */
  private FXMLLoader fxmlSetup() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
          "/com/mikenyugen/linearcodes/MessageNode.fxml"));
      Node node = fxmlLoader.load();
      this.getChildren().add(node);
      return fxmlLoader;
    } catch (IOException e) {
      throw new IOException("FXML loader failure");
    }
  }



}
