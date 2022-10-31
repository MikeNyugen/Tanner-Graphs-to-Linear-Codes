package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.controllers.MainController;
import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * JavaFX component representing a message node.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class MessageNode extends AnchorPane implements BitNode {
  int id;
  static int numberOfNodes = -1;
  ArrayList<Integer> connections = new ArrayList<>();
  MessageNodeController messageNodeController = new MessageNodeController();
  MainController mainController = new MainController();

  /**
   * Loads FXML on initialisation and makes the node draggable.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  public MessageNode() throws IOException {
    numberOfNodes++;
    id = numberOfNodes;
    Node node = retrieveLoader("/com/mikenyugen/linearcodes/MessageNode.fxml", messageNodeController);
    this.getChildren().add(node);
    messageNodeController.setupStyles(numberOfNodes);
    makeDraggable(this); // Makes the node draggable, method imported from JFxtras.labs
    mouseClickedHandlers();
  }

  @Override
  public void mouseClickedHandlers() {
    this.setOnMouseClicked(event -> {
      if (mainController.selectButtonIsSelected()) {
        mainController.getNodesSelected().add(this);
        messageNodeController.getCircle().getStyleClass().add("nodeSelected");
      } else if (mainController.removeSelectionIsSelected()) {
        mainController.getNodesSelected().remove(this);
        messageNodeController.getCircle().getStyleClass().clear();
      }
    });

    this.setOnMouseEntered(event -> {
      messageNodeController.mouseEnteredEventHandler();
    });

    this.setOnMouseExited(event -> {
      messageNodeController.mouseExitedEventHandler();
    });
  }

  public int getNodeId() {
    return id;
  }

  public ArrayList<Integer> getConnections() {
    return connections;
  }

  @Override
  public void clearStyles() {
    messageNodeController.getCircle().getStyleClass().clear();
  }

}
