package com.mikenyugen.linearcodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main class responsible for starting the application.
 */
public class Main extends Application {
  /**
   * The number of source bits specified by the user.
   */
  public static int sourceBits;
  /**
   * The number of parity bits specified by the user.
   */
  public static int parityBits;

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1277, 777);
    scene.getRoot().setStyle("-fx-font-family: 'serif'");
    stage.setTitle("Tanner Graphs to Liner Codes");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}