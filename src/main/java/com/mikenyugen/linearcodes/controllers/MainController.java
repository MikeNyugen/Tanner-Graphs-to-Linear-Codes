package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.Main;
import com.mikenyugen.linearcodes.model.BitNode;
import com.mikenyugen.linearcodes.model.Connection;
import com.mikenyugen.linearcodes.model.MessageNode;
import com.mikenyugen.linearcodes.model.ParityNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  @FXML
  ToggleButton drag;
  @FXML
  ToggleButton selectButton;
  @FXML
  ToggleButton removeSelection;
  @FXML
  ToggleButton addMessageNode;
  @FXML
  ToggleButton addParityNode;
  @FXML
  Button addConnection;
  @FXML
  ToggleButton removeConnection;
  @FXML
  Pane pane;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    clickEventHandlers();
  }

  private void clickEventHandlers() {
    drag.setOnMouseClicked(event -> {
      Main.selection = false;
    });
    selectButton.setOnMouseClicked(event -> {
      Main.selection = true;
      Main.removeSelection = false;
    });
    removeSelection.setOnMouseClicked(event -> {
      Main.selection = false;
      Main.removeSelection = true;
    });
    addConnection.setOnMouseClicked(event -> {
      connectNodes();
    });
    pane.setOnMouseClicked(mouseEvent -> {
      if (addMessageNode.isSelected()) {
        addMessageNode(mouseEvent);
      } else if (addParityNode.isSelected()) {
        addParityNode(mouseEvent);
      }
    });
  }

  /**
   * Handles click events on the canvas.
   *
   * @param mouseEvent Javafx mouse event
   */
  public void paneClickEventHandler(MouseEvent mouseEvent) throws IOException {
    if (addMessageNode.isSelected()) {
      addMessageNode(mouseEvent);
    } else if (addParityNode.isSelected()) {
      addParityNode(mouseEvent);
    }
  }

  /**
   * Adds a message node to the canvus.
   *
   * @param mouseEvent Javafx mouse event
   */
  private void addMessageNode(MouseEvent mouseEvent) {
    int mouseOffset = 25;
    MessageNode messageNode = null;
    try {
      messageNode = new MessageNode();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    messageNode.setLayoutX(mouseEvent.getX() - mouseOffset);
    messageNode.setLayoutY(mouseEvent.getY() - mouseOffset);
    pane.getChildren().add(messageNode);
  }

  /**
   * Adds a parity node to the canvus.
   *
   * @param mouseEvent Javafx mouse event
   */
  private void addParityNode(MouseEvent mouseEvent) {
    int mouseOffset = 25;
    ParityNode parityNode = null;
    try {
      parityNode = new ParityNode();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    parityNode.setLayoutX(mouseEvent.getX() - mouseOffset);
    parityNode.setLayoutY(mouseEvent.getY() - mouseOffset);
    pane.getChildren().add(parityNode);
  }

  /**
   * Connects two nodes that have been selected by the user.
   */
  public void connectNodes() {
    Connection connection = new Connection();
    boolean messageNodeSelectedFirst = connection.determineNodeOrder();
    int messageIndex = messageNodeSelectedFirst ? 0 : 1;
    int parityIndex = !messageNodeSelectedFirst ? 0 : 1;

    MessageNode messageNode = (MessageNode) Main.selectionModel.get(messageIndex);
    ParityNode parityNode = (ParityNode) Main.selectionModel.get(parityIndex);

    connection.setStartEnd(messageNode, parityNode);
    connection.setBindings(messageNode, parityNode);
    connection.setOnMouseClicked(event -> { removeConnection(connection); });
    pane.getChildren().add(connection);

    Main.selectionModel.clear();
    messageNode.clearStyles();
    parityNode.clearStyles();
    connection.toBack();
  }

  public void removeConnection(Connection connection) {
    if (removeConnection.isSelected()) {
      pane.getChildren().remove(connection);
    }
  }


}
