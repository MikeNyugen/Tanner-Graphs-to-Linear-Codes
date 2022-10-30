package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import com.mikenyugen.linearcodes.controllers.ParityNodeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * Defines a method to set up a bit node including loading the FXML file and attaching a controller.
 */
public interface BitNode {

  default Node retrieveLoader(String fxmlLocation, MessageNodeController controller) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlLocation));
    loader.setController(controller);
    return loader.load();
  }

  default Node retrieveLoader(String fxmlLocation, ParityNodeController controller) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlLocation));
    loader.setController(controller);
    return loader.load();
  }

  /**
   * Clears all CSS styles from the node.
   */
  void clearStyles();

  /**
   * Methods to handle mouse click events.
   */
  void mouseClickedHandlers();

}
