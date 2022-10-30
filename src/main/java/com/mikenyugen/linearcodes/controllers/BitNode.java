package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

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
