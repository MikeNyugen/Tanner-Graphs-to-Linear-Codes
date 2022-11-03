package com.mikenyugen.linearcodes.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Represents a table row in a JavaFX table view.
 */
public class TableRow {
  SimpleStringProperty message = new SimpleStringProperty("");
  SimpleStringProperty codeWord = new SimpleStringProperty("");

  public TableRow(String message, String codeWord){
    setMessage(message);
    setCodeWord(codeWord);
  }

  public String getMessage() {return message.get();}

  public SimpleStringProperty messageProperty() {return message;}

  public void setMessage(String message) {
    this.message.set(message);
  }

  public String getCodeWord() {return codeWord.get();}

  public SimpleStringProperty codeWordProperty() {return codeWord;}

  public void setCodeWord(String codeWord) {this.codeWord.set(codeWord);}
}

