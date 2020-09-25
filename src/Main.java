import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        System.out.println("TIC TAC TOE!\n____________\nWhat is your name? ");
        String name = new Scanner(System.in).nextLine();

        while(playAgain) {
            System.out.println("Alright " + name + ". Do you want to be \"X\" or \"O\"?");
            String userPick = new Scanner(System.in).nextLine();
            String pcPick = userPick.equals("x") ? "o" : "x";

            //Create Game Board
            int[][] gameBoard = new int[3][3];
            System.out.println("Alright " + name + ". Let's see if you can beat me. Hehe...");

            //Does user want to play again


        }
    }
}
