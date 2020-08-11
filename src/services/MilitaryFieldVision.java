package services;

import java.util.Set;

public interface MilitaryFieldVision {
    void gameVision(String[][] matrix);

    void finalVision(String[][] matrix, Set<String> mines);
}
