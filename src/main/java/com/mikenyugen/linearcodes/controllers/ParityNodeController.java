package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Responsible for querying elements in the parity node FXML.
 */
public class ParityNodeController implements Initializable {
  /**
   * The number of message nodes present on the canvas.
   */
  static int numNodes = -1;
  /**
   * List of characters representing Labels for the parity node.
   */
  static final String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  @FXML
  Label squareLabel;
  @FXML
  Label circleLabel;
  @FXML
  Line line;
  @FXML
  Rectangle square;
  @FXML
  Circle circle;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    numNodes++;
    setupStyles();
  }

  private void setupStyles() {
    circleLabel.setText("P" + numNodes);
    circleLabel.setStyle("-fx-font-size: 18");
    squareLabel.setText(String.valueOf(CHAR_LIST.charAt(numNodes)));
    squareLabel.setStyle("-fx-font-size: 25");
  }

  @FXML
  private void mouseEnteredEventHandler() {
    square.setFill(Color.DARKGREY);
  }

  @FXML
  private void mouseExitedEventHandler() {
    square.setFill(Color.WHITE);
  }

}