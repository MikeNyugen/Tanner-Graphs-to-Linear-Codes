package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.model.MessageNode;
import com.mikenyugen.linearcodes.model.ParityNode;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable, FxmlLoaderRetriever {

  ToolBarController toolBarController;

  @FXML
  Pane pane;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      loadControllers();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void loadControllers() throws IOException {
    FXMLLoader toolbarLoader = retrieveLoader("/com/mikenyugen/linearcodes/ToolBar.fxml");
    toolBarController = toolbarLoader.getController();
  }

  /**
   * Handles click events on the canvas.
   *
   * @param mouseEvent Javafx mouse event
   */
  public void paneClickEventHandler(MouseEvent mouseEvent) throws IOException {
    if (toolBarController.addMessageNodeIsSelected()) {
      addMessageNode(mouseEvent);
    } else if (toolBarController.addParityNodeIsSelected()) {
      addParityNode(mouseEvent);
    }
  }

  /**
   * Adds a message node to the canvus.
   *
   * @param mouseEvent Javafx mouse event
   */
  private void addMessageNode(MouseEvent mouseEvent) {
    MessageNode messageNode = null;
    try {
      messageNode = new MessageNode();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    messageNode.setLayoutX(mouseEvent.getX() - 25);
    messageNode.setLayoutY(mouseEvent.getY() - 25);
    pane.getChildren().add(messageNode);
  }

  /**
   * Adds a parity node to the canvus.
   *
   * @param mouseEvent Javafx mouse event
   */
  private void addParityNode(MouseEvent mouseEvent) {
    ParityNode parityNode = null;
    try {
      parityNode = new ParityNode();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    parityNode.setLayoutX(mouseEvent.getX() - 25);
    parityNode.setLayoutY(mouseEvent.getY() - 25);
    pane.getChildren().add(parityNode);
  }

}
