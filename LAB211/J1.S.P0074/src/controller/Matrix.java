package controller;

import java.util.Scanner;
import java.util.logging.Logger;

public class Matrix {

    private final Scanner sc = new Scanner(System.in);
    private static final Logger logger = Logger.getLogger(Matrix.class.getName());
    private static final String IVALID_MATRIX = "Ivalid Matrix";

    public void menu() {
        logger.info("=======Calculator program=====");
        logger.info("1. Addition Matrix. ");
        logger.info("2. Subtraction Matrix. ");
        logger.info("3. Multiplication Matrix. ");
        logger.info("4. Quit. ");
    }

    public int enterInt(String content) {
        String s;
        while (true) {
            try {
                logger.info(content);
                s = sc.nextLine().trim();
                if (!s.isEmpty() && s.matches("[-0-9]+")) {
                    return Integer.parseInt(s);
                } else {
                    logger.info("Value of matrix is digit");
                }
            } catch (NumberFormatException e) {
                logger.info(() -> e + "");
            }
        }
    }

    public int enterSize(String content) {
        String s;
        int number;
        while (true) {
            try {
                logger.info(content);
                s = sc.nextLine().trim();
                number = Integer.parseInt(s);
                if (number > 0) {
                    return number;
                } else {
                    logger.info("Enter a number greater than zero");
                }
            } catch (NumberFormatException e) {
                logger.info(() -> e + "");
            }
        }
    }

    public int enterChoice(String content) {
        String s;
        while (true) {
            try {
                logger.info(content);
                s = sc.nextLine().trim();
                if (!s.isEmpty() && s.matches("[1-4]+")) {
                    return Integer.parseInt(s);
                } else {
                    logger.info("Choice form 1 to 4.");
                }
            } catch (NumberFormatException e) {
                logger.info(() -> e + "");
            }
        }
    }

    public int[][] enterMatrix(int x) {
        int row = this.enterSize("Enter Row Matrix " + x + ": ");
        int col = this.enterSize("Enter Column Matrix " + x + ": ");
        int[][] a = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j] = this.enterInt("Enter Matrix " + x + "[" + (i + 1) + "][" + (j + 1) + "]: ");
            }
        }
        return a;
    }

    public void displayMatrix(int[][] a) {
        for (int[] a1 : a) {
            for (int j = 0; j < a1.length; j++) {
                String logMessage = "[" + a1[j] + "]";
                logger.info(logMessage);
            }
            logger.info("");
        }
    }

    public void displayResult(int[][] matrix1, int[][] matrix2, int[][] result, String s) {
        logger.info("----------Result---------");
        this.displayMatrix(matrix1);
        logger.info(s);
        this.displayMatrix(matrix2);
        logger.info("=");
        this.displayMatrix(result);
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            logger.info(IVALID_MATRIX);
            return new int[0][0];
        }
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            logger.info(IVALID_MATRIX);
            return new int[0][0];
        }
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] result = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 != row2) {
            logger.info(IVALID_MATRIX);
            return new int[0][0];
        }
        int[][] result = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                for (int k = 0; k < col1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Matrix ma = new Matrix();
        int choice;
        int[][] matrix1;
        int[][] matrix2;
        int[][] result;
        boolean isExit = false;
        while (!isExit) {
            ma.menu();
            choice = ma.enterChoice("Your choice: ");
            if (choice == 4) {
                isExit = true;
                continue;
            }
            switch (choice) {
                case 1:
                    logger.info("--------- Addition ---------");
                    matrix1 = ma.enterMatrix(1);
                    matrix2 = ma.enterMatrix(2);
                    result = ma.additionMatrix(matrix1, matrix2);
                    if (result != null) {
                        ma.displayResult(matrix1, matrix2, result, "+");
                    }
                    break;
                case 2:
                    logger.info("--------- Subtraction ---------");
                    matrix1 = ma.enterMatrix(1);
                    matrix2 = ma.enterMatrix(2);
                    result = ma.subtractionMatrix(matrix1, matrix2);
                    if (result != null) {
                        ma.displayResult(matrix1, matrix2, result, "-");
                    }
                    break;
                case 3:
                    logger.info("--------- Multiplication ---------");
                    matrix1 = ma.enterMatrix(1);
                    matrix2 = ma.enterMatrix(2);
                    result = ma.multiplicationMatrix(matrix1, matrix2);
                    if (result != null) {
                        ma.displayResult(matrix1, matrix2, result, "*");
                    }
                    break;
                default:
                    break;
            }

        }
    }

}
