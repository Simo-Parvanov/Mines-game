import services.Check;
import services.GameLogic;
import services.MilitaryFieldVision;
import services.impl.CheckImpl;
import services.impl.GameLogicImpl;
import services.impl.MilitaryFieldVisionImpl;

import java.util.Scanner;
import java.util.Set;

import static message.Message.*;

public class Game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Check check = new CheckImpl();
        GameLogic gameLogic = new GameLogicImpl();
        MilitaryFieldVision print = new MilitaryFieldVisionImpl();

        System.out.println(FIRST_MESSAGE);

        int level = Integer.parseInt(scanner.nextLine());

        String[][] matrix = gameLogic.matrixByLevel(level);
        Set<String> mines = gameLogic.setMinesByLevel(level);

        System.out.println(MESSAGE_START_GAME);
        print.gameVision(matrix);
        System.out.println();

        int count = 0;
        while (true) {
            count++;
            System.out.println(String.format(MESSAGE_FOR_MOVE, 0, matrix.length - 1, 0, matrix.length - 1));

            String[] input = scanner.nextLine().split("\\s+");

            if (!check.checkForIncorrectInput(input.length)) {
                System.out.println(MESSAGE_INCORRECT_INPUT_COORDINATES);
                continue;
            }
            int row;
            int col;

            try {
                row = Integer.parseInt(input[0]);
                col = Integer.parseInt(input[1]);
            } catch (Exception ex) {
                System.out.println(MESSAGE_INCORRECT_INPUT_COORDINATES);
                continue;
            }

            if (check.checkForIncorrectCoordinates(input, matrix.length)) {
                System.out.println(MESSAGE_INCORRECT_COORDINATES);
                continue;
            }

            if (check.checkForOpenCell(row, col, matrix)) {
                System.out.println(MESSAGE_FOR_REPEAT_CELL);
                continue;
            }
            if (gameLogic.searchForMine(input[0], input[1], mines)) {
                System.out.println(MESSAGE_LOST);
                print.finalVision(matrix, mines);
                break;
            }
            matrix = gameLogic.move(matrix, mines, input);
            if (check.searchForWin(matrix, mines.size())) {
                System.out.println(String.format(MESSAGE_VICTORY, count));
                print.finalVision(matrix, mines);
                break;
            }
            print.gameVision(matrix);
        }
    }

}


