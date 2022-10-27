module com.example.demo1 {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;


  opens com.mikenyugen.linearcodes to javafx.fxml;
  exports com.mikenyugen.linearcodes;
  exports com.mikenyugen.linearcodes.controllers;
  opens com.mikenyugen.linearcodes.controllers to javafx.fxml;
}