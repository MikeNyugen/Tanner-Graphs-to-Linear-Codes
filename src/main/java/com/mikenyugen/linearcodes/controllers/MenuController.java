package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.Button;
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
  public void initialize(URL location, ResourceBundle resources) {
    spinnerEventHandler();
    submitButtonEventHandler();
  }

  /**
   * Handles the spinner events.
   */
  public void spinnerEventHandler() {
    setSpinnerConstraints();
  }

  /**
   * The number of parity nodes cannot be greater than the number of
   * source nodes. This function enforces this.
   */
  public void setSpinnerConstraints() {
    sourceSpinner.setOnMouseClicked(event -> {
      if (Objects.equals(sourceSpinner.getValue(), paritySpinner.getValue())) {
        paritySpinner.decrement();
      }
    });
    paritySpinner.setOnMouseClicked(event -> {
      if (Objects.equals(paritySpinner.getValue(), sourceSpinner.getValue())) {
        sourceSpinner.increment();
      }
    });
  }

  /**
   * Handles the submit button events.
   */
  public void submitButtonEventHandler() {
    submitButton.setOnMouseClicked( event -> {
      submitInfo();
    });
  }

  /**
   * Takes the value in the spinners and stores them in the global variables defined in Main.
   */
  public void submitInfo() {
    Main.sourceBits = (int) sourceSpinner.getValue();
    Main.parityBits = (int) paritySpinner.getValue();
    submitButton.setDisable(true);
    sourceSpinner.setDisable(true);
    paritySpinner.setDisable(true);
  }

}