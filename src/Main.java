import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        System.out.println("TIC TAC TOE!\n____________\nWhat is your name? ");
        String name = new Scanner(System.in).nextLine();

        while(playAgain) {
            System.out.println("Alright " + name + ". Do you want to be \"X\" or \"O\"?");
            int userPlayer = new Scanner(System.in).nextLine().equals("x") ? 1 : -1;
            int pcPlayer = userPlayer == 1 ? -1 : 1;
            boolean isGameOver = false;

            //Create Game Board
            int[][] gameBoard = new int[3][3];
            System.out.println("Alright " + name + ". Let's see if you can beat me. Hehe...");

            //GAME PLAY
            while(didUserWin()){
                displayGame(gameBoard);
                System.out.println("Choose a spot (1-9).");
                int userPick = new Scanner(System.in).nextInt();
                if(userPick <= 3) gameBoard[0][--userPick] = userPlayer;
                else if(userPick > 3 && userPick <= 6) gameBoard[1][(--userPick) - 3] = userPlayer;
                else if(userPick >= 7) gameBoard[2][(--userPick) - 6] = userPlayer;
            }

            //Does user want to play again
            System.out.println("Do you want to play again? (y/n)");
            playAgain = new Scanner(System.in).nextLine().toLowerCase().charAt(0) == 'y';
        }
    }

    private static boolean didUserWin(int[][] gameBoard) {
//        if(gameBoard.)
    }

    static private void displayGame(int[][] gameBoard){
        int i = 1;
        for(int[] array: gameBoard){
            for (int selection: array) {
                if(!(i % 3 == 0)){
                    if(selection == 1) System.out.print("X   |");
                    else if(selection == -1) System.out.print("O   |");
                    else System.out.print("    |");
                    i++;
                }
                else{
                    if(selection == 1) System.out.print("X");
                    else if(selection == -1) System.out.print("O");
                    else System.out.print(" ");
                    System.out.println("\n_________________");
                    i++;
                }
            }
        }
    }

}
