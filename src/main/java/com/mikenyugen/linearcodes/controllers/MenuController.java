package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
  @FXML
  private Spinner<Integer> sourceSpinner;

  @FXML
  void temp() {
    sourceSpinner.setDisable(true);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}