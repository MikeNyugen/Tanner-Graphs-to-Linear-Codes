package com.mikenyugen.linearcodes.model;

import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * JavaFX component representing a parity node.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 * <p>
 * The 'FxmlComponent' interface defines a default method to load the FXML file.
 */
public class ParityNode extends AnchorPane implements FxmlComponent {

  /**
   * Loads FXML on initialisation and makes the node draggable.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  public ParityNode() throws IOException {
    fxmlSetup(this, "/com/mikenyugen/linearcodes/ParityNode.fxml");
    makeDraggable(this);
  }

}


