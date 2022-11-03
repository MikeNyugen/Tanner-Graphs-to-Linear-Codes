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

  public DisplayTable() {
  }

  public DisplayTable(String message, String codeWord) {
    setMessage(message);
    setCodeWord(codeWord);
  }

  /**
   * Populates the message list from messages in the message matrix.
   *
   * @param messages the messages in the message matrix
   */
  public void populateMessages(DoubleMatrix messages) {
    matrixToList(messages, messageList);
  }

  /**
   * Populates the code word list from code words in the code word matrix.
   *
   * @param codeWords the code words in the code word matrix
   */
  public void populateCodeWords(DoubleMatrix codeWords) {
    matrixToList(codeWords, codeWordList);
  }

  /**
   * Takes the rows on a given matrix and appends them to an array list.
   * The rows correspond to messages or code words e.g. 1011
   *
   * @param matrix the input matrix
   * @param list   the input list
   */
  private void matrixToList(DoubleMatrix matrix, ArrayList<String> list) {
    for (int i = 0; i < matrix.rows; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      DoubleMatrix row = matrix.getRow(i);
      for (int j = 0; j < row.length; j++) {
        stringBuilder.append(((int) matrix.get(i, j)));
      }
      list.add(stringBuilder.toString());
    }
  }

  public void setMessage(String message) {
    this.message.set(message);
  }

  public void setCodeWord(String codeWord) {
    this.codeWord.set(codeWord);
  }

  public ArrayList<String> getMessageList() {
    return messageList;
  }

  public ArrayList<String> getCodeWordList() {
    return codeWordList;
  }
}

