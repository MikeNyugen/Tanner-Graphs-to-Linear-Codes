package com.mikenyugen.linearcodes.model;

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
    fxmlSetup();
    makeDraggable(this);
  }

  /**
   * Sets up the FXML for the parity node.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  private void fxmlSetup() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
          "/com/mikenyugen/linearcodes/ParityNode.fxml"));
      Node node = fxmlLoader.load();
      this.getChildren().add(node);
    } catch (IOException e) {
      throw new IOException("FXML loader failure");
    }
  }
}


