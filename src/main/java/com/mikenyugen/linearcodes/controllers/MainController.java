package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.model.MessageNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
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

  /**
   * Defines methods that run on initial load of the scene.
   *
   * @param location
   * The location used to resolve relative paths for the root object, or
   * {@code null} if the location is not known.
   *
   * @param resources
   * The resources used to localize the root object, or {@code null} if
   * the root object was not localized.
   */
  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    pane.setOnMouseClicked(event -> {
      if (addMessageNode.isSelected()) {
        MessageNode node = new MessageNode();
        node.setLayoutX(event.getX() - 25);
        node.setLayoutY(event.getY() - 25);
        pane.getChildren().add(node);

      }
    });

  }


}
