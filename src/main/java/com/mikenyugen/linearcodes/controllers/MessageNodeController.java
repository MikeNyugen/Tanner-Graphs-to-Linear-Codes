package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Responsible for querying elements in the message node FXML.
 */
public class MessageNodeController  {
  @FXML
  StackPane stack;
  @FXML
  Circle circle;
  @FXML
  Label label;

  public void setupStyles(int numberOfNodes) {
    label.setText("M" + numberOfNodes);
    label.setStyle("-fx-font-size: 18");
  }

  public void mouseEnteredEventHandler() {
    circle.setFill(Color.DARKGREY);
  }

  public void mouseExitedEventHandler() {
    circle.setFill(Color.WHITE);
  }

  public StackPane getStack() {
    return stack;
  }

  public Circle getCircle() {
    return circle;
  }

  public Label getLabel() {
    return label;
  }
}
