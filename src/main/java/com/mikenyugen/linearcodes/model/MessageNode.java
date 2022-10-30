package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.Main;
import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import com.mikenyugen.linearcodes.controllers.ToolBarController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;

import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

/**
 * JavaFX component representing a message node.
 * <p>
 * New components must extend from an existing JavaFX component to be displayed.
 */
public class MessageNode extends AnchorPane  {
  static int numberOfNodes = -1;
  MessageNodeController controller;

  /**
   * Loads FXML on initialisation and makes the node draggable.
   *
   * @throws IOException if the FXML cannot be loaded
   */
  public MessageNode() throws IOException {

    FXMLLoader loader = new FXMLLoader(getClass().getResource(
        "/com/mikenyugen/linearcodes/MessageNode.fxml"));
    controller = new MessageNodeController();
    loader.setController(controller);
    Node n = loader.load();
    numberOfNodes++;
    controller.getLabel().setText("M" + numberOfNodes);
    controller.getLabel().setStyle("-fx-font-size: 18");
    setHoverEffects();
    makeDraggable(this); // Makes the node draggable, method imported from JFxtras.labs
    this.getChildren().add(n);

    this.setOnMouseClicked(event -> {
      if (Main.selection) {
        Main.selectionModel.add(this);
        controller.getCircle().getStyleClass().add("nodeSelected");
      } else if (Main.removeSelection) {
        Main.selectionModel.remove(this);
        controller.getCircle().getStyleClass().clear();
      }
    });
  }

  private void setHoverEffects() {
    this.setOnMouseEntered(event -> {
      controller.getCircle().setFill(Color.LIGHTGREY);
    });
    this.setOnMouseExited(event -> {
      controller.getCircle().setFill(Color.WHITE);
    });
  }

  public void clearStyles() {
    controller.getCircle().getStyleClass().clear();
  }

}
