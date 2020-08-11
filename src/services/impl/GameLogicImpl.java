package services.impl;

import services.GameLogic;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static message.Message.EXPOSED_CELLS;
import static message.Message.START_VIEW;

public class GameLogicImpl implements GameLogic {
    @Override
    public String[][] move(String[][] matrix, Set<String> mines, String[] input) {
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int counterMine = emptyPositionsWithoutMines(matrix, mines, input);
        if (counterMine > 0) {
            matrix[row][col] = String.valueOf(counterMine);
            return matrix;
        }

        Set<String> numMine = blanksAroundTheStep(matrix, mines, input);
        for (String b : numMine) {
            String[] split = b.split("\\s+");
            int rowPosition = Integer.parseInt(split[0]);
            int colPosition = Integer.parseInt(split[1]);
            if (matrix[rowPosition][colPosition].equals(START_VIEW)) {

                matrix[rowPosition][colPosition] = EXPOSED_CELLS;
            }
        }
        matrix[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = EXPOSED_CELLS;
        return matrix;
    }

    @Override
    public Set<String> setMinesByLevel(int level) {
        Set<String> result = new HashSet<>();
        int mines = count(level, "mines");
        Random random = new Random();
        while (result.size() != mines) {
            int row = random.nextInt(count(level, "row"));
            int col = random.nextInt(count(level, "row"));
            result.add(row + " " + col);
        }
        return result;
    }

    @Override
    public String[][] matrixByLevel(int level) {
        int rolAndCol = count(level, "row");
        String[][] matrix = new String[rolAndCol][rolAndCol];
        for (int i = 0; i < rolAndCol; i++) {
            for (int j = 0; j < rolAndCol; j++) {
                matrix[i][j] = START_VIEW;
            }
        }

        return matrix;
    }

    @Override
    public boolean searchForMine(String row, String col, Set<String> mines) {
        String mine = row + " " + col;
        return mines.contains(mine);
    }

    @Override
    public Set<String> blanksAroundTheStep(String[][] matrix, Set<String> mines, String[] input) {
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        //Check on the cell above the step
        Set<String> result = new HashSet<>();
        if (row - 1 > -1) {
            result.add(String.format("%d %d", row - 1, col));
        }
        //Check on the cell below the step
        if (row + 1 <= matrix.length - 1) {
            result.add(String.format("%d %d", row + 1, col));
        }
        //Check on the cell to the right of the step
        if (col + 1 <= matrix.length - 1) {
            result.add(String.format("%d %d", row, col + 1));
        }
        //Check the cell to the left of the step
        if (col - 1 > -1) {
            result.add(String.format("%d %d", row, col - 1));
        }
        //Check on the cell in the lower left corner of the step
        if (row + 1 <= matrix.length - 1 & col - 1 > -1) {
            result.add(String.format("%d %d", row + 1, col - 1));
        }
        //Check on the cell in the upper left corner of the step
        if (row - 1 > -1 & col - 1 > -1) {
            result.add(String.format("%d %d", row - 1, col - 1));
        }
        //Check on the cell in the upper right corner of the step
        if (row - 1 > -1 & col + 1 <= matrix.length - 1) {
            result.add(String.format("%d %d", row - 1, col + 1));
        }
        //Check on the cell in the lower right corner of the step
        if (row + 1 <= matrix.length - 1 & col + 1 <= matrix.length - 1) {
            result.add(String.format("%d %d", row + 1, col + 1));
        }
        return result;
    }

    @Override
    public int emptyPositionsWithoutMines(String[][] matrix, Set<String> mines, String[] input) {
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int counter = 0;

        //Check on the cell above the step
        if (row - 1 > -1) {
            if (mines.contains(String.format("%d %d", row - 1, col))) {
                counter++;
            }
        }
        //Check on the cell below the step
        if (row + 1 <= matrix.length - 1) {
            if (mines.contains(String.format("%d %d", row + 1, col))) {
                counter++;
            }
        }
        //Check on the cell to the right of the step
        if (col + 1 <= matrix.length - 1) {
            if (mines.contains(String.format("%d %d", row, col + 1))) {
                counter++;
            }
        }
        //Check on the cell to the left of the step
        if (col - 1 > -1) {
            if (mines.contains(String.format("%d %d", row, col - 1))) {
                counter++;
            }
        }
        //Check on the cell in the lower left corner of the step
        if (row + 1 <= matrix.length - 1 & col - 1 > -1) {
            if (mines.contains(String.format("%d %d", row + 1, col - 1))) {
                counter++;
            }
        }
        //Check on the cell in the upper left corner of the step
        if (row - 1 > -1 & col - 1 > -1) {
            if (mines.contains(String.format("%d %d", row - 1, col - 1))) {
                counter++;
            }
        }
        //Check on the cell in the upper right corner of the step
        if (row - 1 > -1 & col + 1 <= matrix.length - 1) {
            if (mines.contains(String.format("%d %d", row - 1, col + 1))) {
                counter++;
            }
        }
        //Check on the cell in the lower right corner of the step
        if (row + 1 <= matrix.length - 1 & col + 1 <= matrix.length - 1) {
            if (mines.contains(String.format("%d %d", row + 1, col + 1))) {
                counter++;
            }
        }
        return counter;
    }

    private int count(int level, String s) {
        int result = 0;
        if (s.equals("row")){
            switch (level) {
                case 0:
                    result = 9;
                    break;
                case 1:
                    result = 16;
                    break;
                case 2:
                    result = 24;
                    break;
            }
        }else {
            switch (level) {
                case 0:
                    result = 10;
                    break;
                case 1:
                    result = 40;
                    break;
                case 2:
                    result = 99;
                    break;
            }
        }
        return result;
    }
}
