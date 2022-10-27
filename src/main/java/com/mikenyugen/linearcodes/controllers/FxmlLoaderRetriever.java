package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Defines a method to retrieve FXMLLoader objects.
 *
 * Used to retrieved injected controllers from FXML files.
 */
public interface FxmlLoaderRetriever {

  /**
   * Returns an FXML Loader object given a path to the file.
   *
   * @param url the absolute path of the FXML file
   * @return a FXMLLoader object
   * @throws IOException if the FXML file fails to load
   */
  default FXMLLoader retrieveLoader(String url) throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/mikenyugen/linearcodes/ToolBar.fxml"));
    Parent root = loader.load();
    return loader;
  }
}
