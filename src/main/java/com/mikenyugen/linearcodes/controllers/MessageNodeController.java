package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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

  @FXML
  private void mouseClickedHandler(MouseEvent mouseEvent) {
    if (Main.selection && Main.nodesSelected < 2) {
      Main.nodesSelected++;
      circle.getStyleClass().add("nodeSelected");
    } else if (Main.removeSelection) {
      Main.nodesSelected--;
      circle.getStyleClass().clear();
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
