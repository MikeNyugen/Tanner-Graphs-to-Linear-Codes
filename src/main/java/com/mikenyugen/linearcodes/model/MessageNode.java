package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.Main;
import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * JavaFX component representing a message node.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class MessageNode extends AnchorPane implements BitNode {
  static int numberOfNodes = -1;
  MessageNodeController controller = new MessageNodeController();

  /**
   * Loads FXML on initialisation and makes the node draggable.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  public MessageNode() throws IOException {
    numberOfNodes++;
    Node node = retrieveLoader("/com/mikenyugen/linearcodes/MessageNode.fxml", controller);
    this.getChildren().add(node);
    controller.setupStyles(numberOfNodes);
    makeDraggable(this); // Makes the node draggable, method imported from JFxtras.labs
    mouseClickedHandlers();
  }

  @Override
  public void mouseClickedHandlers() {
    this.setOnMouseClicked(event -> {
      if (Main.selection) {
        Main.selectionModel.add(this);
        controller.getCircle().getStyleClass().add("nodeSelected");
      } else if (Main.removeSelection) {
        Main.selectionModel.remove(this);
        controller.getCircle().getStyleClass().clear();
      }
    });

    this.setOnMouseEntered(event -> {
      controller.mouseEnteredEventHandler();
    });

    this.setOnMouseExited(event -> {
      controller.mouseExitedEventHandler();
    });
  }

  @Override
  public void clearStyles() {
    controller.getCircle().getStyleClass().clear();
  }

}
