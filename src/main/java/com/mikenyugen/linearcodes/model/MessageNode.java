package com.mikenyugen.linearcodes.model;

import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * JavaFX component representing a message node.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 * <p>
 * The 'FxmlComponent' interface defines a default method to load the FXML file.
 */
public class MessageNode extends AnchorPane implements FxmlComponent {

  /**
   * Loads FXML on initialisation and makes the node draggable.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  public MessageNode() throws IOException {
    fxmlSetup(this, "/com/mikenyugen/linearcodes/MessageNode.fxml");
    makeDraggable(this); // Makes the node draggable, method imported from JFxtras.labs
  }

}
