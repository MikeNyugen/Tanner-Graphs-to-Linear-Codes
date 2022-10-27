package com.mikenyugen.linearcodes.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Defines methods to construct a new JavaFX component.
 */
public interface FxmlComponent {

  /**
   * Loads the FXML file of the new component.
   *
   * @param component the new component object
   * @param url       the absolute path of the FXML file
   * @throws IOException if the FXML cannot be loaded
   */
  default void fxmlSetup(Pane component, String url) throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));
      Node node = fxmlLoader.load();
      component.getChildren().add(node);
    } catch (IOException e) {
      throw new IOException("FXML loader failure");
    }
  }

}
