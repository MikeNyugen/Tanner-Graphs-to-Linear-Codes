package com.mikenyugen.linearcodes.model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Connection extends Line {
  public Connection() {
    super();
    setHoverEffects();
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
