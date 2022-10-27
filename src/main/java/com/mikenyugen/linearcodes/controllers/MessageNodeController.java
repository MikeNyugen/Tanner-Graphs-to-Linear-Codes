package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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
  static int numNodes = 0;

  @FXML
  StackPane stack;
  @FXML
  Circle circle;
  @FXML
  Label label;

  public StackPane getStack() { return stack; }

  public Circle getCircle() { return circle; }

  public Label getLabel() { return label; }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    setupStyles();
  }

  private void setupStyles() {
    label.setText("M" + numNodes);
    label.setStyle("-fx-font-size: 18");
  }

  public void incrementNodes() {
    numNodes++;
  }

}
