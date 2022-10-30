module com.mikenyugen.linearcodes {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;
  requires jfxtras.labs;


  opens com.mikenyugen.linearcodes to javafx.fxml;
  exports com.mikenyugen.linearcodes;
  exports com.mikenyugen.linearcodes.controllers;
  opens com.mikenyugen.linearcodes.controllers to javafx.fxml;
  exports com.mikenyugen.linearcodes.model;
  opens com.mikenyugen.linearcodes.model to javafx.fxml;
}