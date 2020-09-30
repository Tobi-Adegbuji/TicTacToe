import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        System.out.println("TIC TAC TOE!\n____________\nWhat is your name? ");
        String name = new Scanner(System.in).nextLine();

        while(playAgain) {
            System.out.println("Alright " + name + ". Do you want to be \"X\" or \"O\"?");
            int userPlayer = new Scanner(System.in).nextLine().equals("x") ? 1 : -1;
            int pc = userPlayer == 1 ? -1 : 1;

            //Create Game Board
            int[][] gameBoard = new int[3][3];
            Set<Integer> positionsUsedAlready = new HashSet<>();
            System.out.println("Alright " + name + ". Let's see if you can beat me. Hehe...");

            //GAME PLAY
            while(isGameStillOn(gameBoard, userPlayer, pc).equals("yes")){
                displayGame(gameBoard);
                System.out.println("Choose a spot (1-9).");

                //USER TURN
                boolean isNotValidPick = true;
                int userPick = 0;
                while(isNotValidPick) {
                    int userChoice = new Scanner(System.in).nextInt();
                    if (positionsUsedAlready.contains(userChoice)) {
                        System.out.println("This position is taken. Pick another one.");
                        continue;
                    }
                    positionsUsedAlready.add(userChoice);
                    userPick = userChoice;
                    isNotValidPick = false;
                }
                if(userPick <= 3)
                    gameBoard[0][--userPick] = userPlayer;
                else if(userPick > 3 && userPick <= 6)
                    gameBoard[1][(--userPick) - 3] = userPlayer;
                else if(userPick >= 7 )
                    gameBoard[2][(--userPick) - 6] = userPlayer;

                List<Integer> list = new ArrayList<>();
                for (int[] array: gameBoard) {
                    for (int i: array) {
                        list.add(i);
                    }
                }
                if(!list.contains(0))
                    break;

                //CPU TURN
                Random random = new Random();
                isNotValidPick = true;
                int pcPick = 0;
                while(isNotValidPick) {
                    int pcChoice = random.nextInt(9) + 1;
                    if (positionsUsedAlready.contains(pcChoice))
                        continue;
                    positionsUsedAlready.add(pcChoice);
                    pcPick = pcChoice;
                    isNotValidPick = false;
                }

                if(pcPick <= 3)
                    gameBoard[0][--pcPick] = pc;
                else if(pcPick > 3 && pcPick <= 6)
                    gameBoard[1][(--pcPick) - 3] = pc;
                else if(pcPick >= 7)
                    gameBoard[2][(--pcPick) - 6] = pc;


            }
            displayGame(gameBoard);
            decideWinner(gameBoard,userPlayer,pc);
            //Does user want to play again
            System.out.println("Do you want to play again? (y/n)");
            playAgain = new Scanner(System.in).nextLine().toLowerCase().charAt(0) == 'y';


        }
    }

    private static void decideWinner(int[][] gameBoard, int userPlayer, int pc){
        if(isGameStillOn(gameBoard,userPlayer,pc).equals("tie"))
            System.out.println("Looks like a tie to me!");
        else if(isGameStillOn(gameBoard,userPlayer,pc).equals("you"))
            System.out.println("It looks like " + isGameStillOn(gameBoard, userPlayer, pc) +" have won :)");
        else
            System.out.println("It looks like I won... :)");

    }

    private static String isGameStillOn(int[][] gameBoard, int userPlayer, int pc) {

        int userPlayerCount = 0;
        int pcCount = 0;

        //CHECK HORIZONTAL
        for (int[] array: gameBoard) {
            for (int i: array) {
                if(i == userPlayer)
                    userPlayerCount++;
                if (i == pc)
                    pcCount++;
            }
            if (userPlayerCount == 3)
                return "you";
            else if(pcCount == 3)
                return "pc";
            else {
                userPlayerCount = 0;
                pcCount = 0;
            }
        }
        //CHECK VERTICAL
        for(int i = 0; i < gameBoard.length; i++){
            for(int j = 0; j < gameBoard.length; j++){
                if(gameBoard[j][i] == userPlayer)
                    userPlayerCount++;
                if (gameBoard[j][i] == pc)
                    pcCount++;
            }
            if (userPlayerCount == 3)
                return "you";
            else if(pcCount == 3)
                return "pc";
            else {
                userPlayerCount = 0;
                pcCount = 0;
            }
        }

        if((gameBoard[0][0] == pc && gameBoard[1][1] == pc && gameBoard[2][2] == pc) ||
                (gameBoard[2][0] == pc && gameBoard[1][1] == pc && gameBoard[0][2] == pc))
            return "pc";

        if((gameBoard[0][0] == userPlayer && gameBoard[1][1] == userPlayer && gameBoard[2][2] == userPlayer) ||
                (gameBoard[2][0] == userPlayer && gameBoard[1][1] == userPlayer && gameBoard[0][2] == userPlayer))
            return "you";


        List<Integer> list = new ArrayList<>();
        for (int[] array: gameBoard) {
            for (int i: array) {
                list.add(i);
            }
        }


        if(!list.contains(0))
            return "tie";

        return "yes";
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
