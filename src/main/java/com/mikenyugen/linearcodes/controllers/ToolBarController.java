package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Maintains the state of the toolbar buttons.
 */
public class ToolBarController implements Initializable {
  @FXML
  ToggleButton selectButton;
  @FXML
  ToggleButton addMessageNode;
  @FXML
  ToggleButton addParityNode;

  static Map<String, Boolean>  buttons = new HashMap<>() {{
    put("addMessageNode", false);
    put("addParityNode", false);
    put("select", false);
  }};

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    buttonClickHandlers();
  }

  public void buttonClickHandlers() {
    addMessageNode.setOnMouseClicked(event -> {
      enforceButtonToggle("addMessageNode");
    });
    addParityNode.setOnMouseClicked(event -> {
      enforceButtonToggle("addParityNode");
    });
    selectButton.setOnMouseClicked(event -> {
      enforceButtonToggle("select");
    });
  }

  /**
   * Ensures that only one button is toggled at a time.
   *
   * @param button the button clicked by the user
   */
  public void enforceButtonToggle(String button) {
    if (!buttons.get(button)) {
      buttons.replaceAll((key, value) -> false);
      buttons.replace(button, true);
    } else {
      buttons.replace(button, false);
    }
  }

  public boolean addMessageNodeIsSelected() {
    return buttons.get("addMessageNode");
  }

  public boolean addParityNodeIsSelected() {
    return buttons.get("addParityNode");
  }

  public boolean selectIsSelected() {
    return buttons.get("select");
  }

}
