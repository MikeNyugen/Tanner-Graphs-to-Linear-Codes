package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import com.mikenyugen.linearcodes.controllers.ParityNodeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * Responsible for displaying the parity node correctly.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class ParityNode extends AnchorPane {
  @FXML
  ParityNodeController parityNodeController;

  public ParityNode() throws IOException {
    super();
    parityNodeSetup();
    makeDraggable(this);
  }

  /**
   * Loads FXML and binds the controller.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  private void parityNodeSetup() throws IOException {
    // Load FXML
    FXMLLoader fxmlLoader = fxmlSetup();
    // Bind FXML to controller
    parityNodeController = new ParityNodeController();
    fxmlLoader.setController(parityNodeController);
  }

  /**
   * Sets up the FXML for the parity node.
   *
   * @return a FXML loader object
   * @throws IOException if the FXML cannot be loaded
   */
  private FXMLLoader fxmlSetup() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
          "/com/mikenyugen/linearcodes/ParityNode.fxml"));
      Node node = fxmlLoader.load();
      this.getChildren().add(node);
      return fxmlLoader;
    } catch (IOException e) {
      throw new IOException("FXML loader failure");
    }
  }
}


