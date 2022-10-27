package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;

/**
 * Responsible for querying elements in the message node FXML.
 */
public class MessageNodeController {
  @FXML
  StackPane stack;
  @FXML
  Circle circle;
  @FXML
  Label label;

  public StackPane getStack() { return stack; }

  public Circle getCircle() { return circle; }

  public Label getLabel() { return label; }
}
