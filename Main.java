import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int userWin=0;
        int computerWin=0;

        System.out.println("Welcome to to 3x3 Tic Tac Toe");
        System.out.println("Chose number of rounds \n1-Play one round \n2- Play 3 rounds and then determine the winner ");
        int round = input.nextInt();

        while (round!=2&&round!=1) {
            System.out.println("Please choose 1 or 2 rounds");
            round = input.nextInt();
        }
        int maxRounds = round == 1 ? 1 : 3;
            for (int i = 0; i < maxRounds; i++) {
                String[][] board = resetBoard();
                String winner = null;
                String turn = "X";

                System.out.println("Let's start round " + (i + 1));
                printBoard(board);
                System.out.println("X will play first, Enter a slot number to place X in:");

                //Player turn
                while (winner == null) {
                    int numInput;
                    try {
                        numInput = input.nextInt();
                        if (numInput < 1 || numInput > 9) {
                            System.out.println("Invalid input; re-enter slot number:");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(
                                "Invalid input; re-enter slot number:");
                        continue;
                    }//end try

                    int row = (numInput - 1) / 3;
                    int col = (numInput - 1) % 3;
                    if (board[row][col].equals(String.valueOf(numInput))) {
                        board[row][col] = turn;

                        printBoard(board);
                        winner = checkWinner(board);

                        //Computer turn
                        if (winner == null) {
                            turn = "O";
                            int computerMove;
                            do {
                                computerMove = random.nextInt(9) + 1;
                                row = (computerMove - 1) / 3;
                                col = (computerMove - 1) % 3;
                            } while (!board[row][col].equals(String.valueOf(computerMove)));

                            board[row][col] = turn;
                            System.out.println("Computer place O in " + computerMove);
                            printBoard(board);
                            winner = checkWinner(board);
                            turn = "X";
                        }
                    }//end if
                    else System.out.println("Slot already taken; re-enter slot number:");

                }//end while
                if ("X".equals(winner)) {
                    userWin++;
                    System.out.println("You win this round!");
                } else if ("O".equals(winner)) {
                    computerWin++;
                    System.out.println("Computer win this round!");
                } else System.out.println("It's a draw for this round!");

            }  //end for loop
            //Display final score
                System.out.println("Final score : you- "+userWin+" , Computer - "+computerWin);
                if(userWin>computerWin){
                    System.out.println("Congratulations! You are the overall winner!");
                }else if (computerWin>userWin){
                    System.out.println("Computer is the overall winner! Better luck next time!");
                }else System.out.println("It's a draw! Thanks for playing.");




        }//end main

public static String[][] resetBoard(){
    String[][] board = new String[3][3];
    int count = 0;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = String.valueOf(count + 1);
            count++;
        }
    }
    return board;
}

    public static void printBoard(String[][] board) throws IllegalArgumentException {
        if (board.length != 3 || board[0].length != 3) {
            throw new IllegalArgumentException("Board must have 3x3 elements");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("----------");
            }
        }

    }

    public static String checkWinner(String[][] board) {
        String line = null;
        int i = 0;
        int j = 0;
        for (int a = 0; a < 8; a++) {
            switch (a) {
                case 0:
                    line = board[i][j] + board[i][j + 1] + board[i][j + 2];
                    break;
                case 1:
                    line = board[i + 1][j] + board[i + 1][j + 1] + board[i + 1][j + 2];
                    break;
                case 2:
                    line = board[i + 2][j] + board[i + 2][j + 1] + board[i + 2][j + 2];
                    break;
                case 3:
                    line = board[i][j] + board[i + 1][j] + board[i + 2][j];
                    break;
                case 4:
                    line = board[i][j + 1] + board[i + 1][j + 1] + board[i + 2][j + 1];
                    break;
                case 5:
                    line = board[i][j + 2] + board[i + 1][j + 2] + board[i + 2][j + 2];
                    break;
                case 6:
                    line = board[i][j] + board[i + 1][j + 1] + board[i + 2][j + 2];
                    break;
                case 7:
                    line = board[i][j + 2] + board[i + 1][j + 1] + board[i + 2][j];
            }


            if (line.equals("XXX")) {
                return "X";
            } else if (line.equals("OOO"))
                return "O";
        }//end loop

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!board[r][c].equals("X") && !board[r][c].equals("O")) {
                    return null;
                }
            }
        }
return "draw";
    }



}//end class