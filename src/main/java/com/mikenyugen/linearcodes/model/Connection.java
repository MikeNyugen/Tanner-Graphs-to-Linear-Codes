package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.Main;
import javafx.beans.binding.Bindings;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Represents a connection between two nodes.
 */
public class Connection extends Line {
  public Connection() {
    super();
    setStrokeWidth(4);
    setHoverEffects();
  }

  /**
   * Determines whether the first node selected was a message node or a parity node.
   *
   * @return true if the first node selected is a message node and false otherwise.
   */
  public boolean determineNodeOrder() {
    Node firstNode = Main.selectionModel.get(0);
    Node secondNode = Main.selectionModel.get(1);
    return firstNode instanceof MessageNode &&
        secondNode instanceof ParityNode;
  }

  /**
   * Sets the start and end position of the line to be the center of two given nodes.
   *
   * @param messageNode the message node to be connected
   * @param parityNode  the parity node to be connected
   */
  public void setStartEnd(MessageNode messageNode, ParityNode parityNode) {
    this.setStartX(messageNode.getLayoutX());
    this.setStartY(messageNode.getLayoutY());
    this.setEndX(parityNode.getLayoutX());
    this.setEndY(parityNode.getLayoutY());
  }

  /**
   * Sets a binding between two nodes.
   * <p>
   * Ensures that the connection is maintained when the nodes are repositioned.
   *
   * @param messageNode the message node to be connected
   * @param parityNode  the parity node to be connected
   */
  public void setBindings(MessageNode messageNode, ParityNode parityNode) {
    int centerOffset = 50;
    this.startXProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds bounds = messageNode.getBoundsInParent();
      return bounds.getMinX() + bounds.getWidth() / 2;
    }, messageNode.boundsInParentProperty()));

    this.startYProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds bounds = messageNode.getBoundsInParent();
      return bounds.getMinY() + bounds.getHeight() / 2;
    }, messageNode.boundsInParentProperty()));

    this.endXProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds bounds = parityNode.getBoundsInParent();
      return bounds.getMinX() + bounds.getWidth() / 2;
    }, parityNode.boundsInParentProperty()));

    this.endYProperty().bind(Bindings.createDoubleBinding(() -> {
      Bounds bounds = parityNode.getBoundsInParent();
      return bounds.getMinY() - centerOffset + bounds.getHeight() / 2;
    }, parityNode.boundsInParentProperty()));
  }

  private void setHoverEffects() {
    this.setOnMouseEntered(event -> {
      this.setStrokeWidth(5);
      this.setStroke(Color.LIGHTGREY);
    });
    this.setOnMouseExited(event -> {
      this.setStrokeWidth(4);
      this.setStroke(Color.BLACK);
    });
  }
}
