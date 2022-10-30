package com.mikenyugen.linearcodes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

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
  /**
   * The number of nodes that the user has selected.
   */
  public static int nodesSelected = 0;

  public static boolean selection = false;

  public static boolean removeSelection = false;

  public static ArrayList<Node> selectionModel = new ArrayList<>();

  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 1277, 777);
    scene.getRoot().setStyle("-fx-font-family: 'Helvetica'");
    stage.setTitle("Tanner Graphs to Liner Codes");
    scene.getStylesheets().add("styles.css");
    stage.setScene(scene);
    stage.show();
  }
}