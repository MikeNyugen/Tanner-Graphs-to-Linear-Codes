package com.mikenyugen.linearcodes.controllers;

import com.mikenyugen.linearcodes.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import org.jblas.DoubleMatrix;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
  public static ArrayList<Point> adjacencyMatrix = new ArrayList<>();
  static boolean selectButtonIsSelected = false;
  static boolean removeSelectionIsSelected = false;
  static ArrayList<Node> nodesSelected = new ArrayList<>();
  MenuController menuController = new MenuController();
  ArrayList<MessageNode> messageNodeList = new ArrayList<>();

  @FXML
  Accordion accordion;
  @FXML
  TitledPane configure;
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
  Button run;
  @FXML
  TableColumn<Code, String> messageColumn;
  @FXML
  TableColumn<Code, String> codewordColumn;
  @FXML
  TableView<Code> tableView;

  @FXML
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    accordion.setExpandedPane(configure);
    clickEventHandlers();
  }

  private void clickEventHandlers() {
    drag.setOnMouseClicked(event -> {
      selectButtonIsSelected = false;
      removeSelectionIsSelected = false;
    });
    selectButton.setOnMouseClicked(event -> {
      selectButtonIsSelected = true;
      removeSelectionIsSelected = false;
    });
    removeSelection.setOnMouseClicked(event -> {
      selectButtonIsSelected = false;
      removeSelectionIsSelected = true;
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

    run.setOnMouseClicked(event -> {
      Matrix matrix = new Matrix();
      adjacencyMatrix.clear();

      for (MessageNode messageNode : messageNodeList) {
        for (int i = 0; i < messageNode.getConnections().size(); i++) {
          adjacencyMatrix.add(new Point(messageNode.getConnections().get(i), messageNode.getNodeId()));
        }
      }

      // populate tableview
      int sourceBits = menuController.getSourceBits();
      int parityBits = menuController.getParityBits();
      DoubleMatrix codeWords = matrix.parityCheckToCodeWords(adjacencyMatrix, sourceBits, parityBits,
          sourceBits - parityBits);
      DoubleMatrix messages = matrix.generateMessages(sourceBits - parityBits);
      messageColumn.setCellValueFactory(new PropertyValueFactory<>("message"));
      codewordColumn.setCellValueFactory(new PropertyValueFactory<>("codeWord"));
      ObservableList<Code> observableList = FXCollections.observableArrayList();

      DisplayTable displayTable = new DisplayTable();

      displayTable.populateMessages(messages);
      displayTable.populateCodeWords(codeWords);

      for (int i = 0; i < displayTable.getMessageList().size(); i++) {
        observableList.add(new Code(displayTable.getMessageList().get(i), displayTable.getCodeWordList().get(i)));
      }
      tableView.getItems().setAll(observableList);
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
      messageNodeList.add(messageNode);
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

    MessageNode messageNode = (MessageNode) nodesSelected.get(messageIndex);
    ParityNode parityNode = (ParityNode) nodesSelected.get(parityIndex);
    messageNode.getConnections().add(parityNode.getNodeId());

    connection.setStartEnd(messageNode, parityNode);
    connection.setBindings(messageNode, parityNode);
    connection.setOnMouseClicked(event -> {
      removeConnection(connection);
    });
    pane.getChildren().add(connection);

    nodesSelected.clear();
    messageNode.clearStyles();
    parityNode.clearStyles();
    connection.toBack();
  }

  public void removeConnection(Connection connection) {
    if (removeConnection.isSelected()) {
      pane.getChildren().remove(connection);
    }
  }

  public boolean selectButtonIsSelected() {
    return selectButtonIsSelected;
  }

  public boolean removeSelectionIsSelected() {
    return removeSelectionIsSelected;
  }

  public ArrayList<Node> getNodesSelected() {
    return nodesSelected;
  }

}
