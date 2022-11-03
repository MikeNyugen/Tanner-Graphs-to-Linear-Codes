package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.Main;
import javafx.scene.Node;
import javafx.scene.control.Spinner;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxAssert;
import org.testfx.framework.junit.ApplicationTest;

/**
 * Tests the functionality of the menu.
 */
public class MenuTest extends ApplicationTest {
  @BeforeAll
  public static void setUpClass() throws Exception {
    ApplicationTest.launch(Main.class);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.show();
  }

  // increments and decrement spinner values and verify if values change
  @Test
  public void spinner() {
    Spinner sourceSpinner = find("#sourceSpinner");
    Spinner paritySpinner = find("#paritySpinner");

    incrementSpinner(sourceSpinner);
    FxAssert.verifyThat(sourceSpinner, (Spinner spinner) -> {
      int value = (int) spinner.getValue();
      return (value == 3);
    });

    incrementSpinner(paritySpinner);
    FxAssert.verifyThat(paritySpinner, (Spinner spinner) -> {
      int value = (int) spinner.getValue();
      return (value == 2);
    });

    decrementSpinner(sourceSpinner);
    FxAssert.verifyThat(sourceSpinner, (Spinner spinner) -> {
      int value = (int) spinner.getValue();
      return (value == 2);
    });

    FxAssert.verifyThat(paritySpinner, (Spinner spinner) -> {
      int value = (int) spinner.getValue();
      return (value == 1);
    });
  }

  @Test
  public void submitClick() {
    clickOn("#submitButton");
  }

  // Helper method to retrieve JavaFX GUI components
  public <T extends Node> T find(final String query) {
    return (T) lookup(query).queryAll().iterator().next();
  }


  // Helper method to increment the spinner
  public <T extends Node> void incrementSpinner(final Spinner<T> combo) {
    clickOn(combo.lookup(".increment-arrow-button"), MouseButton.PRIMARY);
  }

  // Helper method to decrement the spinner
  public <T extends Node> void decrementSpinner(final Spinner<T> combo) {
    clickOn(combo.lookup(".decrement-arrow-button"), MouseButton.PRIMARY);
  }
}
