package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Responsible for querying elements in the parity node FXML.
 */
public class ParityNodeController {
  /**
   * List of characters representing Labels for the parity node.
   */
  static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  @FXML
  Label squareLabel;
  @FXML
  Label circleLabel;
  @FXML
  Rectangle square;

  public void setupStyles(int numberOfNodes) {
    circleLabel.setText("P" + numberOfNodes);
    circleLabel.setStyle("-fx-font-size: 18");
    squareLabel.setText(String.valueOf(CHAR_LIST.charAt(numberOfNodes)));
    squareLabel.setStyle("-fx-font-size: 25");
  }

  public void mouseEnteredEventHandler() {
    square.setFill(Color.DARKGREY);
  }

  public void mouseExitedEventHandler() {
    square.setFill(Color.WHITE);
  }

  public Rectangle getSquare() {
    return square;
  }

}
