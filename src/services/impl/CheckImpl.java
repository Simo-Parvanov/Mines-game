package services.impl;

import services.Check;

import static message.Message.EXPOSED_CELLS;
import static message.Message.START_VIEW;

public class CheckImpl implements Check {


    @Override
    public boolean checkForIncorrectInput(int size) {
        return size == 2;
    }

    @Override
    public boolean checkForIncorrectCoordinates(String[] input, int matrixSize) {
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        return (row > matrixSize - 1 || row < 0 || col > matrixSize - 1 || col < 0);
    }

    @Override
    public boolean checkForOpenCell(int row, int col, String[][] matrix) {

        return (matrix[row][col].equals(EXPOSED_CELLS));
    }

    @Override
    public boolean searchForWin(String[][] matrix, int minesSize) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals(START_VIEW)) {
                    count++;
                }
            }
        }
        return count == minesSize;
    }
}
