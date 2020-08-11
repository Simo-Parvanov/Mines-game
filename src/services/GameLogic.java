package services;

import java.util.Set;

public interface GameLogic {
    String[][] move(String[][] matrix, Set<String> mines, String[] input);

    Set<String> setMinesByLevel(int level);

    String[][] matrixByLevel(int level);

    boolean searchForMine(String row, String col, Set<String> mines);

    Set<String> blanksAroundTheStep(String[][] matrix, Set<String> mines, String[] input);

    int emptyPositionsWithoutMines(String[][] matrix, Set<String> mines, String[] input);
}
