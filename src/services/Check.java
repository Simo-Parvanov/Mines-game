package services;

public interface Check {

    boolean checkForIncorrectInput(int size);

    boolean checkForIncorrectCoordinates(String[] input, int matrixSize);

    boolean checkForOpenCell(int row, int col, String[][] matrix);

    boolean searchForWin(String[][] matrix, int minesSize);

//    void errorChecker();

}
