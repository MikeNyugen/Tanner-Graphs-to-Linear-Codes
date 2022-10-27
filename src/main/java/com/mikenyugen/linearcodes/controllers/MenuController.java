package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller responsible for side menu interactions.
 */
public class MenuController implements Initializable {
  @FXML
  private Spinner<Integer> sourceSpinner;
  @FXML
  private Spinner<Integer> paritySpinner;
  @FXML
  private Button submitButton;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {}

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
   *
   * Values stored in the spinners will be copied
   * to the global variables stored in Main.
   */
  public void submitButtonClickHandler() {
    Main.sourceBits = sourceSpinner.getValue();
    Main.parityBits = paritySpinner.getValue();

    submitButton.setDisable(true);
    sourceSpinner.setDisable(true);
    paritySpinner.setDisable(true);
    System.out.println(Main.sourceBits);
  }

}