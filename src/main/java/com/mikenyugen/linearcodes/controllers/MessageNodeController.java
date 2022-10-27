package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Responsible for querying elements in the message node FXML.
 */
public class MessageNodeController implements Initializable, FxmlLoaderRetriever {
  /**
   * The number of message nodes present on the canvas.
   */
  static int numNodes = -1;

  ToolBarController toolBarController;

  @FXML
  StackPane stack;
  @FXML
  Circle circle;
  @FXML
  Label messageNodeLabel;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      loadControllers();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    numNodes++;
    setupStyles();
  }

  private void loadControllers() throws IOException {
    FXMLLoader toolbarLoader = retrieveLoader("/com/mikenyugen/linearcodes/ToolBar.fxml");
    toolBarController = toolbarLoader.getController();
  }

  private void setupStyles() {
    messageNodeLabel.setText("M" + numNodes);
    messageNodeLabel.setStyle("-fx-font-size: 18");
  }

  @FXML
  private void mouseClickedHandler() {
      if (toolBarController.selectIsSelected()) {
        circle.getStyleClass().add("nodeSelected");
      }
  }

  @FXML
  private void mouseEnteredEventHandler() {
      circle.setFill(Color.DARKGREY);
  }

  @FXML
  private void mouseExitedEventHandler() {
    circle.setFill(Color.WHITE);
  }

}
