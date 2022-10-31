package com.mikenyugen.linearcodes.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

import java.util.Objects;

/**
 * Controller responsible for side menu interactions.
 */
public class MenuController {
  @FXML
  private Spinner<Integer> sourceSpinner;
  @FXML
  private Spinner<Integer> paritySpinner;
  @FXML
  private Button submitButton;

  private static int sourceBits;

  private static int parityBits;

  /**
   * Decrements the value of the parity spinner if the value of the source spinner is the same.
   *
   * The number of parity nodes cannot be greater than the number of source nodes.
   */
  public void sourceSpinnerClickHandler() {
    boolean equalSpinnerValue = Objects.equals(sourceSpinner.getValue(), paritySpinner.getValue());
    if (equalSpinnerValue) {
      paritySpinner.decrement();
    }
  }

  /**
   * Increments the value of the source spinner if the value of the parity spinner is the same.
   *
   * The number of parity nodes cannot be greater than the number of source nodes.
   */
  public void paritySpinnerClickHandler() {
    boolean equalSpinnerValue = Objects.equals(sourceSpinner.getValue(), paritySpinner.getValue());
    if (equalSpinnerValue) {
      sourceSpinner.increment();
    }
  }

  /**
   * Handles the submit button events.
   */
  public void submitButtonClickHandler() {
    sourceBits = sourceSpinner.getValue();
    parityBits = paritySpinner.getValue();

    submitButton.setDisable(true);
    sourceSpinner.setDisable(true);
    paritySpinner.setDisable(true);
  }

  public int getSourceBits() {
    return sourceBits;
  }

  public int getParityBits() {
    return parityBits;
  }


}