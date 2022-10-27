package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller responsible for spinner interactions.
 */
public class SpinnerController {

  @FXML
  public Spinner<Integer> sourceSpinner;
  @FXML
  public Spinner<Integer> paritySpinner;

  @FXML
  public void initialize() {
    setSpinnerConstraints();
  }

  /**
   * The number of parity nodes cannot be greater than the number of
   * source nodes. This function enforces this.
   */
  public void setSpinnerConstraints() {
    sourceSpinner.setOnMouseClicked(event -> {
      if (sourceSpinner.getValue() == paritySpinner.getValue()) {
        paritySpinner.decrement();
      }
    });
    paritySpinner.setOnMouseClicked(event -> {
      if (paritySpinner.getValue() == sourceSpinner.getValue()) {
        sourceSpinner.increment();
      }
    });
  }

}
