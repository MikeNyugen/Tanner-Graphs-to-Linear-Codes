package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.model.MessageNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  @FXML
  MenuController menuController;
  @FXML
  ToggleButton addMessageNode;
  @FXML
  ToggleButton addParityNode;
  @FXML
  Pane pane;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
  }

  /**
   * Handles click events on the canvas.
   *
   * @param mouseEvent Javafx mouse event
   */
  public void paneClickEventHandler(MouseEvent mouseEvent) {
    if (addMessageNode.isSelected()) {
      addMessageNode(mouseEvent);
    }
  }

  /**
   * Adds a message node to the canvus.
   *
   * @param mouseEvent Javafx mouse event
   */
  private void addMessageNode(MouseEvent mouseEvent) {
    MessageNode messageNode = null;
    try {
      messageNode = new MessageNode();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    messageNode.setLayoutX(mouseEvent.getX() - 25);
    messageNode.setLayoutY(mouseEvent.getY() - 25);
    pane.getChildren().add(messageNode);
  }


}
