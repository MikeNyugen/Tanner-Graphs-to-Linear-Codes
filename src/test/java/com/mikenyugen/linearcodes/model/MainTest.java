package com.mikenyugen.linearcodes.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

/**
 * Tests if the application launches correctly.
 */
public class MainTest extends ApplicationTest {

  @BeforeAll
  public static void setUp() throws Exception {
  }

  @AfterAll
  public static void tearDown() throws Exception {
    FxToolkit.hideStage();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/main/resources/MainScene.fxml"));
    primaryStage.setTitle("Linear Codes");
    Scene scene = new Scene(root, 1080, 762);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  @Test
  void start() {}
}
