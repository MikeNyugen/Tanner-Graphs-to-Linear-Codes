package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.Main;
import com.mikenyugen.linearcodes.controllers.MainController;
import com.mikenyugen.linearcodes.controllers.ParityNodeController;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * JavaFX component representing a parity node.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class ParityNode extends AnchorPane implements BitNode {
  int id;
  static int numberOfNodes = -1;
  ParityNodeController parityNodeController = new ParityNodeController();
  MainController mainController = new MainController();

  /**
   * Loads FXML on initialisation and makes the node draggable.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  public ParityNode() throws IOException {
    numberOfNodes++;
    id = numberOfNodes;
    Node node = retrieveLoader("/com/mikenyugen/linearcodes/ParityNode.fxml", parityNodeController);
    this.getChildren().add(node);
    parityNodeController.setupStyles(numberOfNodes);
    makeDraggable(this); // Makes the node draggable, method imported from JFxtras.labs
    mouseClickedHandlers();
  }

  @Override
  public void mouseClickedHandlers() {
    this.setOnMouseClicked(event -> {
      if (mainController.selectButtonIsSelected()) {
        mainController.getNodesSelected().add(this);
        parityNodeController.getSquare().getStyleClass().add("nodeSelected");
      } else if (mainController.removeSelectionIsSelected()) {
        mainController.getNodesSelected().remove(this);
        parityNodeController.getSquare().getStyleClass().clear();
      }
    });

    this.setOnMouseEntered(event -> {
      parityNodeController.mouseEnteredEventHandler();
    });

    this.setOnMouseExited(event -> {
      parityNodeController.mouseExitedEventHandler();
    });
  }

  public int getNodeId() {
    return id;
  }

  @Override
  public void clearStyles() {
    parityNodeController.getSquare().getStyleClass().clear();
  }

}


