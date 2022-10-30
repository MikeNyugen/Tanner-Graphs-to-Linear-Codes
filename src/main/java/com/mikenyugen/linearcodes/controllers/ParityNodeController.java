package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.Main;
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
public class ParityNodeController implements Initializable, FxmlLoaderRetriever {
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
    Main.parityNodesPresent++;
    setupStyles();
  }

  public void setupStyles() {
    circleLabel.setText("P" + Main.parityNodesPresent);
    circleLabel.setStyle("-fx-font-size: 18");
    squareLabel.setText(String.valueOf(CHAR_LIST.charAt(Main.parityNodesPresent)));
    squareLabel.setStyle("-fx-font-size: 25");
  }

  public void mouseClickedHandler() {
    if (Main.selection && Main.nodesSelected < 2) {
      Main.nodesSelected++;
      square.getStyleClass().add("nodeSelected");
    } else if (Main.removeSelection) {
      Main.nodesSelected--;
      square.getStyleClass().clear();
    }
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
