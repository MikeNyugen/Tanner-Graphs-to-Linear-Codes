package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Responsible for querying elements in the message node FXML.
 */
public class MessageNodeController implements Initializable {
  /**
   * The number of message nodes present on the canvas.
   */
  static int numNodes = -1;

  @FXML
  StackPane stack;
  @FXML
  Circle circle;
  @FXML
  Label messageNodeLabel;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    numNodes++;
    setupStyles();
  }

  private void setupStyles() {
    messageNodeLabel.setText("M" + numNodes);
    messageNodeLabel.setStyle("-fx-font-size: 18");
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
