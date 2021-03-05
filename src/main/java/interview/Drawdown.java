package interview;

import java.util.LinkedList;

public class Drawdown {

    public static void printWinner(int[] endBoard) {
        final int playerOne = 0;
        final int playerTwo = endBoard.length - 1;
        if (endBoard[playerOne] > endBoard[playerTwo]) {
            System.out.println("Player One Won");
        } else {
            System.out.println("Player Two Won");
        }
    }

    public static boolean isValidMove(int[] curBoard, int[] move) {
        // move is valid if curBoard + move results in > nums at each index
        for (int i = 0; i < curBoard.length ; i++) {
            if (!(curBoard[i] + move[i] > 0)) {
                return false;
            }
        }

        return true;
    }

    public static int[] createNewBoard(int[] old, int[] moves) {
        final int[] newBoard = new int[old.length];
        for (int i = 0; i < old.length ; i++) {
            newBoard[i] = old[i] + moves[i];
        }
        return newBoard;
    }

    public static void playGameAndPrintWinner(int[] board, int[][] possibleMoves) {
        final LinkedList<int[]> boardQueue = new LinkedList<>();

        boardQueue.add(board);
        while (!boardQueue.isEmpty()) {
            int[] curBoard = boardQueue.pollFirst();
            boolean changed = false;
            for (int[] move : possibleMoves) {
                if (isValidMove(curBoard, move)) {
                    boardQueue.addLast(createNewBoard(curBoard, move));
                    changed = true;
                }
            }

            if (!changed) {
                printWinner(curBoard);
            }
        }
    }

    public static void main(final String[] args) {
        final int[] initialBoard = new int[]{6,4,2,4};
        final int[][] moves = { {-2, -2, 1, 0},
                {-4, -4, 0, 0},
                {0, 0, -2, -2} };

        playGameAndPrintWinner(initialBoard, moves);
    }
}
