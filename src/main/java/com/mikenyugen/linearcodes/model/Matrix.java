package com.mikenyugen.linearcodes.model;

import org.jblas.DoubleMatrix;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Contains matrix manipulation logic.
 */
public class Matrix {

  public Matrix() {
  }

  /**
   * Returns a parity-check matrix given a list of connections and the number of rows and columns.
   *
   * @param connections a list containing the rows and columns that contain a connection
   * @param rows        the number of rows of the matrix
   * @param columns     the number of columns of the matrix
   * @return a new parity matrix
   */
  public static DoubleMatrix createParityMatrix(ArrayList<Point> connections,
                                                int rows, int columns) {
    // Initialise matrix with zero values
    DoubleMatrix parityMatrix = new DoubleMatrix(rows, columns);
    // Traverse array of edges
    for (Point connection : connections) {
      // Find x and y of edges
      int x = connection.x;
      int y = connection.y;
      // Update value to 1
      parityMatrix.put(x, y, 1);
    }
    return parityMatrix;
  }


  /**
   * Generates all binary messages of a given length.
   *
   * @param length the length of the message
   * @return a matrix containing the messages
   */
  public DoubleMatrix generateMessages(int length) {
    // Array containing messages in string form
    String[] strArray = new String[(int) Math.pow(2, length)];
    // 2D output array
    DoubleMatrix output = new DoubleMatrix((int) Math.pow(2, length), length);
    // Add binary string values to strArray
    for (int i = 0; i < Math.pow(2, length); i++) {
      String numString = String.format("%" + length + "s",
          Integer.toBinaryString(i)).replace(' ', '0');
      strArray[i] = numString;
    }
    // Convert string values into int matrix values and
    // add to output matrix
    for (int j = 0; j < strArray.length; j++) {
      for (int k = 0; k < strArray[j].length(); k++) {
        output.put(j, k, (int) strArray[j].charAt(k) - 48);
      }
    }
    return output;
  }

  /**
   * Creates a generator matrix from a given a parity matrix.
   *
   * @param parityMatrix the parity matrix to be converted
   * @param sourceBits   the number of source bits
   * @param parityBits   the number of parity bits
   * @return a binary matrix
   */
  public DoubleMatrix createGeneratorMatrix(DoubleMatrix parityMatrix,
                                            int sourceBits, int parityBits) {
    int identitySize = sourceBits - parityBits;
    // Identity matrix is placed on top of parity matrix which results in a generator matrix
    return DoubleMatrix.concatVertically(DoubleMatrix.eye(identitySize), parityMatrix);
  }

  /**
   * Generates the code words given a generator matrix and a matrix of messages.
   *
   * @param generator the generator matrix
   * @param messages  a matrix containing messages
   * @return a matrix containing the code words
   */
  public DoubleMatrix generateCodewords(DoubleMatrix generator,
                                        DoubleMatrix messages) {
    DoubleMatrix output = new DoubleMatrix(messages.rows, generator.rows);
    for (int i = 0; i < messages.rows; i++) {
      output.putRow(i, binaryMultiply(generator, messages.getRow(i).transpose()));
    }
    return output;
  }

  /**
   * Performs a binary multiplication given two matrices.
   *
   * @param m1 the first matrix
   * @param m2 the second matrix
   * @return a matrix containing the result of the binary multiplication
   */
  public DoubleMatrix binaryMultiply(DoubleMatrix m1, DoubleMatrix m2) {
    DoubleMatrix output = new DoubleMatrix(m1.rows, m2.columns);
    int countOnes = 0;
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < m1.rows; i++) {
      for (int j = 0; j < m2.columns; j++) {
        for (int k = 0; k < m1.columns; k++) {
          list.add((int) (m1.get(i, k) * m2.get(k, j)));
        }
        countOnes = Collections.frequency(list, 1);
        if (!(countOnes % 2 == 0)) {
          output.put(i, j, 1);
        } else {
          output.put(i, j, 0);
        }
        list.clear();
      }
    }
    return output;
  }
}
