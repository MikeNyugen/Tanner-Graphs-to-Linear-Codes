package com.mikenyugen.linearcodes.model;

import org.jblas.DoubleMatrix;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 *  Tests the correctness of the matrix calculations.
 */
public class MatrixTest {
  Matrix matrix = new Matrix();

  @Test
  void createParityMatrixTest() {
    // 2x2 matrix
    ArrayList<Point> list = new ArrayList<>();
    list.add(new Point(0, 0));
    list.add(new Point(0, 1));
    list.add(new Point(1, 0));
    list.add(new Point(1, 1));
    assertEquals(matrix.createParityMatrix(list, 2, 2),
        new DoubleMatrix((new double[][]
            {{1, 1}, {1, 1}})));
    // 3x3 matrix
    ArrayList<Point> list2 = new ArrayList<>();
    list2.add(new Point(0, 0));
    list2.add(new Point(0, 1));
    list2.add(new Point(1, 1));
    list2.add(new Point(2, 0));
    list2.add(new Point(2, 2));
    assertEquals(matrix.createParityMatrix(list2, 3, 3),
        new DoubleMatrix((new double[][]
            {{1, 1, 0}, {0, 1, 0}, {1, 0, 1}})));
  }

  @Test
  void createGeneratorMatrixTest() {
    // 2x2 matrix (3,1) code
    DoubleMatrix parityMatrix = new DoubleMatrix(new double[][]
        {{1, 1}, {1, 1}});
    assertEquals(matrix.createGeneratorMatrix(parityMatrix, 3, 1),
        new DoubleMatrix(new double[][]
            {{1, 0}, {0, 1}, {1, 1}, {1, 1}}));
    // 3x3 matrix (4,1) code
    DoubleMatrix parityMatrix2 = new DoubleMatrix(new double[][]
        {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
    assertEquals(matrix.createGeneratorMatrix(parityMatrix2, 4, 1),
        new DoubleMatrix((new double[][]
               {{1, 0, 0}, {0, 1, 0}, {0, 0, 1},
                {1, 1, 1}, {1, 1, 1}, {1, 1, 1}})));
  }

  @Test
  void generateMessagesTest() {
    // n = 2
    DoubleMatrix messages = new DoubleMatrix(new double[][]
        {{0, 0}, {0, 1}, {1, 0}, {1, 1}});
    assertEquals(matrix.generateMessages(2), messages);
    // n = 3
    DoubleMatrix messages2 = new DoubleMatrix(new double[][]
        {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0},
            {1, 0, 1}, {1, 1, 0}, {1, 1, 1}});
    assertEquals(matrix.generateMessages(3), messages2);
  }

  @Test
  void generateCodewordsTest() {
    // 2x2 matrix
    DoubleMatrix generator = new DoubleMatrix(new double[][]
        {{1, 0}, {0, 1}, {1, 1}, {1, 1}});
    DoubleMatrix messages = matrix.generateMessages(2);
    DoubleMatrix codeWords = new DoubleMatrix(new double[][]
        {{0, 0, 0, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}, {1, 1, 0, 0}});
    assertEquals(matrix.generateCodewords(generator, messages), codeWords);

    // 3x3 matrix
    DoubleMatrix generator2 = new DoubleMatrix(new double[][]
        {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {1, 1, 1}, {1, 1, 1}});
    DoubleMatrix messages2 = matrix.generateMessages(3);
    DoubleMatrix codeWords2 = new DoubleMatrix(new double[][]
           {{0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 1}, {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 1, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}});
    assertEquals(matrix.generateCodewords(generator2, messages2), codeWords2);

    // [1] (7,4) Hamming code
    DoubleMatrix generator3 = new DoubleMatrix(new double[][]
           {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
            {1, 0, 1, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}});

    DoubleMatrix messages3 = matrix.generateMessages(4);
    DoubleMatrix codeWords3 = new DoubleMatrix(new double[][]
           {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 1, 1}, {0, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 1}, {0, 1, 0, 1, 1, 1, 0}, {0, 1, 1, 0, 1, 0, 0}, {0, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 0},
            {1, 1, 0, 0, 1, 0, 1}, {1, 1, 0, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 1, 1}});
    assertEquals(codeWords3, matrix.generateCodewords(generator3, messages3));

    // [2] (7,4) Hamming code
    DoubleMatrix generator4 = new DoubleMatrix(new double[][]
        {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
            {1, 1, 0, 1}, {1, 0, 1, 1}, {0, 1, 1, 1}});
    DoubleMatrix messages4 = matrix.generateMessages(4);
    DoubleMatrix codeWords4 = new DoubleMatrix(new double[][]
           {{0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 1, 1}, {0, 0, 1, 0, 0, 1, 1}, {0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 1}, {0, 1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1, 0}, {0, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 0, 1}, {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 0, 1, 0},
            {1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 1, 1, 0, 0}, {1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1}});
    assertEquals(codeWords4, matrix.generateCodewords(generator4, messages4));
  }

}
