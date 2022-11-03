package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.Main;
import javafx.scene.Node;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit.ApplicationTest;

/**
 * Tests the functionality of the nodes.
 */
public class NodeTest extends ApplicationTest {
  @BeforeAll
  public static void setUpClass() throws Exception {
    ApplicationTest.launch(Main.class);
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.show();
  }

  @Test
  public void addNodes() {
    clickOn("#submitButton");
    // Add message node
    clickOn("#addMessageNode");
    clickOn(1200, 600);
    // Add parity node
    clickOn("#addParityNode");
    clickOn(1400, 600);
    // Drag test both nodes
    drag(1200, 600);
    dropBy(100, 100);
    drag(1400, 600);
    dropBy(100, 100);
    // Select nodes
    clickOn("#selectButton");
    clickOn(1300, 700);
    clickOn(1500, 700);
    // Connect nodes
    clickOn("#addConnection");
    clickOn("#drag");
    // Drag nodes
    drag(1300, 700);
    dropBy(-100, -100);
    drag(1500, 700);
    dropBy(200, -200);

    clickOn("#run");
  }

  // Helper method to retrieve JavaFX GUI components
  public <T extends Node> T find(final String query) {
    return (T) lookup(query).queryAll().iterator().next();
  }
}
