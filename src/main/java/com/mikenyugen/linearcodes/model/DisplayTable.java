package com.mikenyugen.linearcodes.model;

import javafx.beans.property.SimpleStringProperty;
import org.jblas.DoubleMatrix;

import java.util.ArrayList;

/**
 * Defines methods for displaying code words and messages in a table view.
 */
public class DisplayTable {
  SimpleStringProperty message = new SimpleStringProperty("");
  SimpleStringProperty codeWord = new SimpleStringProperty("");
  ArrayList<String> messageList = new ArrayList<>();
  ArrayList<String> codeWordList = new ArrayList<>();

  public DisplayTable() {}

  public DisplayTable(String message, String codeWord){
    setMessage(message);
    setCodeWord(codeWord);
  }

  public void populateMessages(DoubleMatrix messages) {
    for (int i = 0; i < messages.rows; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      DoubleMatrix row = messages.getRow(i);
      for (int j = 0; j < row.length; j++) {
        stringBuilder.append(((int) messages.get(i, j)));
      }
      messageList.add(stringBuilder.toString());
    }
  }

  public void populateCodeWords(DoubleMatrix codeWords) {
    for (int i = 0; i < codeWords.rows; i++) {
      StringBuilder temp = new StringBuilder();
      DoubleMatrix row = codeWords.getRow(i);
      for (int j = 0; j < row.length; j++) {
        temp.append(((int) codeWords.get(i, j)));
      }
      codeWordList.add(temp.toString());
    }

  }

  public void setMessage(String message) {
    this.message.set(message);
  }

  public void setCodeWord(String codeWord) {this.codeWord.set(codeWord);}

  public ArrayList<String> getMessageList() {
    return messageList;
  }

  public ArrayList<String> getCodeWordList() {
    return codeWordList;
  }
}

