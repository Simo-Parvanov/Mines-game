package message;

public class Message {
    public static final String MESSAGE_FOR_MOVE = "Enter your move, (row from %d-%d empty space column from %d-%d) ->";
    public static final String MESSAGE_INCORRECT_INPUT_COORDINATES = "Incorrectly input. Please, try again!";
    public static final String MESSAGE_INCORRECT_COORDINATES = "Incorrectly entered coordinates. Please, try again!";
    public static final String MESSAGE_FOR_REPEAT_CELL = "The cell is already open. Please set new coordinates!";
    public static final String MESSAGE_LOST = "You lost!";
    public static final String MESSAGE_VICTORY = "Congratulations, you won with %d moves";
    public static final String MESSAGE_FOR_INPUT_LEVEL = "Choice of difficulty level:";
    public static final String MESSAGE_START_GAME = "Your military zone - Good luck :)";
    public static final String MESSAGE_FOR_LEVEL1 = "Enter 0 for BEGINNER (9 * 9 Calls and 10 Mines)";
    public static final String MESSAGE_FOR_LEVEL2 = "Enter 1 for BEGINNER (16 * 16 Calls and 10 Mines)";
    public static final String MESSAGE_FOR_LEVEL3 = "Enter 2 for BEGINNER (24 * 24 Calls and 10 Mines)";
    public static final String FIRST_MESSAGE = String.format("%s\n" + "%s\n" + "%s\n" + "%s",
            MESSAGE_FOR_INPUT_LEVEL,
            MESSAGE_FOR_LEVEL1,
            MESSAGE_FOR_LEVEL2,
            MESSAGE_FOR_LEVEL3);
    public static final String BOMB_SYMBOL = "*";
    public static final String START_VIEW = "O";
    public static final String EXPOSED_CELLS = "X";
}
