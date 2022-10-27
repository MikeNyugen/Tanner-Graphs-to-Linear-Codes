package com.mikenyugen.linearcodes.model;

import com.mikenyugen.linearcodes.controllers.MessageNodeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import static jfxtras.labs.util.event.MouseControlUtil.makeDraggable;

public class MessageNode extends AnchorPane {
  MessageNodeController controller;

  public MessageNode()  {
    super();
    try {
      // load fxml
      FXMLLoader loader = new FXMLLoader(getClass().getResource(
          "/MessageNode.fxml"));
      controller = new MessageNodeController();
      loader.setController(controller);
      Node n = loader.load();

      makeDraggable(this);
      this.getChildren().add(n);
    } catch (IOException ix) {}
  }

  private void FXMLSetup() throws IOException {
    FXMLLoader loader = new FXMLLoader(getClass().getResource(
        "../../../../../resources/MessageNode.fxml"));
    controller = new MessageNodeController();
    loader.setController(controller);
    Node n = loader.load();
    makeDraggable(this);
    this.getChildren().add(n);
  }

}
