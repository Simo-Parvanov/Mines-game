package services.impl;

import services.MilitaryFieldVision;

import java.util.Set;

import static message.Message.BOMB_SYMBOL;

public class MilitaryFieldVisionImpl implements MilitaryFieldVision {

    @Override
    public void gameVision(String[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf(" %s ", matrix[i][j]);
            }
            System.out.println();

        }
    }

    @Override
    public void finalVision(String[][] matrix, Set<String> mines) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (mines.contains(i + " " + j)) {
                    matrix[i][j] = BOMB_SYMBOL;
                }
                System.out.printf(" %s ", matrix[i][j]);
            }
            System.out.println();

        }
    }
}
