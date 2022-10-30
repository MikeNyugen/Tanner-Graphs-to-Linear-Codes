package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.Main;
import com.mikenyugen.linearcodes.model.Connection;
import com.mikenyugen.linearcodes.model.MessageNode;
import com.mikenyugen.linearcodes.model.ParityNode;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
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
  Button addConnection;
  @FXML
  ToggleButton selectButton;
  @FXML
  ToggleButton removeSelection;
  @FXML
  ToggleButton addMessageNode;
  @FXML
  ToggleButton addParityNode;
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
      connect();
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

  public void connect() {
    int messageIndex;
    int parityIndex;

    Node firstNode = Main.selectionModel.get(0);
    Node secondNode = Main.selectionModel.get(1);
    Connection line = new Connection();
    line.setStrokeWidth(4);

    if (firstNode instanceof MessageNode &&
        secondNode instanceof ParityNode) {
      messageIndex = 0;
      parityIndex = 1;
    } else {
      messageIndex = 1;
      parityIndex = 0;
    }

    MessageNode m1 = (MessageNode) Main.selectionModel.get(messageIndex);
    ParityNode p1 = (ParityNode) Main.selectionModel.get(parityIndex);

    line.setStartX(m1.getLayoutX());
    line.setStartY(m1.getLayoutY());
    line.setEndX(p1.getLayoutX());
    line.setEndY(p1.getLayoutY());

    // Set bindings
    line.startXProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds b = m1.getBoundsInParent();
      return b.getMinX() + b.getWidth() / 2;
    }, m1.boundsInParentProperty()));

    line.startYProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds b = m1.getBoundsInParent();
      return b.getMinY() + b.getHeight() / 2;
    }, m1.boundsInParentProperty()));

    line.endXProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds b = p1.getBoundsInParent();
      return b.getMinX() + b.getWidth() / 2;
    }, p1.boundsInParentProperty()));

    line.endYProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds b = p1.getBoundsInParent();
      return b.getMinY() - 50 + b.getHeight() / 2;
    }, p1.boundsInParentProperty()));

    Main.selectionModel.clear();

    m1.clearStyles();
    p1.clearStyles();

    pane.getChildren().add(line);

    line.toBack();
  }

}
