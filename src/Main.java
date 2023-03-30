import java.util.*;
import java.util.Random;

public class Main {


    static String[] grid;
    static boolean Winner = false;
    static int turn = 1;
    static int IsThereAWinner = 4;
    static boolean replay = true;
    static int Plays = 0;


//-------------------------------------------------------------------------------------------------------------

    //Method that prints the grid
    //Methods called inside: None
    static void printgrid() {
        System.out.println(" " + grid[0] + " | " + grid[1] + " | " + grid[2]);
        System.out.println("-----------");
        System.out.println(" " + grid[3] + " | " + grid[4] + " | " + grid[5]);
        System.out.println("-----------");
        System.out.println(" " + grid[6] + " | " + grid[7] + " | " + grid[8]);

        //System.out.println("\n---------------------------------------------");
    }


    //Prints out the rules for the player to read and understand
    //Methods called inside: None
    static void Rules() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Here are the rules:\n");
        //System.out.println(" ");
        System.out.println("This game is played on a 3x3 grid.\n\n" +
                "You are X and you are playing against R (the computer).\n\n" +
                "You will start by placing an X on the board, then you and the \n" +
                "computer will take turns placing pieces on the board.\n\n" +
                "Your goal is to have three Xs in a straight line (could be horizontal, \n" +
                "vertical or diagonal) while stopping the computer from having three Rs in \n" +
                "a straight line.\n\n" +
                "If all of the 9 squares of the board get filled up, the game is a draw.");
        System.out.println("-------------------------------------------------------------------------\n");
    }


    //Checks if the input of the user is in line with what the game is asking
    //Methods called inside: None
    static String IfsValidInput(String Inputv2) {

        String validInput;
        Inputv2 = Inputv2.toLowerCase();

        if (Objects.equals(Inputv2, "0")) {
            validInput = "0";
        } else if (Objects.equals(Inputv2, "1")) {
            validInput = "1";
        } else if (Objects.equals(Inputv2, "2")) {
            validInput = "2";
        } else if (Objects.equals(Inputv2, "3")) {
            validInput = "3";
        } else if (Objects.equals(Inputv2, "4")) {
            validInput = "4";
        } else if (Objects.equals(Inputv2, "5")) {
            validInput = "5";
        } else if (Objects.equals(Inputv2, "6")) {
            validInput = "6";
        } else if (Objects.equals(Inputv2, "7")) {
            validInput = "7";
        } else if (Objects.equals(Inputv2, "8")) {
            validInput = "8";
        } else if (Objects.equals(Inputv2, "stop")){
            validInput = "10";
        } else {
            validInput = "9";
        }
        return validInput;
    }

//-------------------------------------------------------------------------------------------------------------








    //Win methods
//-------------------------------------------------------------------------------------------------------------
    //Checks each win condition to find if there is a win or not, updates IsThereAWinner
    //Methods called inside: None
    static Integer didSomeoneWin() {
        int winType = 4;
        int numtimes = 0;
        for(int a = 0; a< 8;a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = grid[0] + grid[1] + grid[2];
                    break;
                case 1:
                    line = grid[3] + grid[4] + grid[5];
                    break;
                case 2:
                    line = grid[6] + grid[7] + grid[8];
                    break;
                case 3:
                    line = grid[0] + grid[3] + grid[6];
                    break;
                case 4:
                    line = grid[1] + grid[4] + grid[7];
                    break;
                case 5:
                    line = grid[2] + grid[5] + grid[8];
                    break;
                case 6:
                    line = grid[0] + grid[4] + grid[8];
                    break;
                case 7:
                    line = grid[2] + grid[4] + grid[6];
                    break;
            }



            //If there is no draw but someone might have won
            if (Plays != 9) {

                //If X Wins
                if (line.equals("XXX")) {
                    winType = 1;
                    //System.out.println("X Wins");
                    break;
                }

                //If O Wins
                else if (line.equals("RRR")) {
                    winType = 2;
                    //System.out.println("R Wins");
                    break;
                }

                //If there are no winners, the game can keep going
                else {
                    winType = 4;
                    //System.out.println("Nothing");
                }
            }

            //If it is the last play of the game, first check if someone won,
            //if not then there is a draw
            else {
                numtimes += 1;

                //If X Wins
                if (line.equals("XXX")) {
                    winType = 1;
                    //System.out.println("X Wins");
                    break;
                }

                //If O Wins
                else if (line.equals("RRR")) {
                    winType = 2;
                    //System.out.println("R Wins");
                    break;
                }


                //If there are no winners, the game can keep going
                else if (numtimes == 8){
                    winType = 3;
                    //System.out.println("Draw");
                    break;
                }

                else {
                winType = 4;
                }
            }


        }
        return winType;
    }


    //After IsThereAWinner has been changed this method tells the player is there is a winner and stops the game
    //Methods called inside: None
    static void someOneWon(){
        //If X won
        if (IsThereAWinner == 1) {
            System.out.println("\n---------------------------------------------");
            System.out.println("X Won Wohoo lets go");
            Winner = true;
        }


        //If O won
        else if (IsThereAWinner == 2) {
            System.out.println("\n---------------------------------------------");
            System.out.println("R Won OHHHHH NOOOOO");
            Winner = true;
        }


        //If there is a draw
        else if  (IsThereAWinner == 3){
            System.out.println("\n---------------------------------------------");
            System.out.println("There's a draw");
            Winner = true;
        }

        else if (IsThereAWinner == 4){
            Winner = false;
        }
    }
//-------------------------------------------------------------------------------------------------------------








    //Scanner Methods
//-------------------------------------------------------------------------------------------------------------

    //Asks the player if he wants the rules or if he wants to start directly
    //Methods called inside: None
    static public String ScannerStart(String YesNo2){
        System.out.println("\n---------------------------------------------");
        System.out.println("Are you ready to start? (type “y” if yes, type “r” if you want to read the rules\nand type \"stop\" if you want to stop playing)");
        Scanner YesNo = new Scanner(System.in);
        String YesNo_Answer = YesNo.nextLine();
        YesNo2 = YesNo_Answer;
        YesNo2 = YesNo2.toLowerCase();
        return YesNo2;
    }


    //Scanner for the inputs during the game
    //Methods called inside: None
    static public String Scanner_2(){
        System.out.println("\n---------------------------------------------");
        System.out.println("Give me a square number in which you want an X: (From 0 - 8)");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }

//-------------------------------------------------------------------------------------------------------------








//-------------------------------------------------------------------------------------------------------------

    //Asks if you want to replay
    //Methods called inside: None
    static boolean Endgame(){
        boolean goodInput = false; //If the user inputs the right thing this turns
        //into true and stops repeating the question

        boolean ReplayYN = false; //This tells if the player want to start another game


        while (goodInput == false) {

            //Scanner to get the user's input
            Scanner replayYN = new Scanner(System.in);
            System.out.println("\n---------------------------------------------");
            System.out.println("\nDo you want to replay? (\"y\" if you want to replay, \"n\" "+
                    "if you want to stop playing)");
            String input = replayYN.nextLine();

            input = input.toLowerCase();//changes the input to lower case

            //If user said "Y", he wants to play again so ReplayYN = true and goodInput = true
            //Also winner = false because they are going to start another game
            if (Objects.equals(input, "y")) {
                goodInput = true;
                ReplayYN = true;
                Winner = false;
            }

            //If user said "n", he doesn't want to play do ReplayYN = false and goodInput = true
            else if (Objects.equals(input, "n")) {
                goodInput = true;
                ReplayYN = false;
                System.out.println("Thank you for playing the game!");
                System.exit(0);
            }
            else if (Objects.equals(input, "stop")){
                System.out.println("Thank you for playing the game!");
                System.exit(0);
            }

            //If user said something else, it is a miss-input and I ask again so goodInput = false
            else {
                goodInput = false;
                System.out.println("Wrong input, Please input \"y\" or \"n\"");
            }
        }
        return ReplayYN;
    }

//-------------------------------------------------------------------------------------------------------------








//-------------------------------------------------------------------------------------------------------------
    //Does everything when the game has started, also asks the user if he wants to restart
    //Methods called inside: Scanner_2(), IfsValidInput(), printgrid(), didSomeoneWin(), someOneWon(), Endgame()
    static public void GameInputs(){

        while (IsThereAWinner == 4) {
            if (turn == 1) {


                //While it is X's turn to play
                while (turn == 1) {


                    String XInput;
                    int XInputInt;
                    //Asks the user for an input
                    XInput = Scanner_2();

                    //Find out if it's a number that is in the grid
                    XInput = IfsValidInput(XInput);

                    //turns the input into an integer
                    XInputInt = Integer.parseInt(XInput);



                    //If the input is good and if the square wanted is not already taken,

                    if (XInputInt >= 0 && XInputInt <= 8) {
                        if (grid[XInputInt].equals("X") || grid[XInputInt].equals("R")) {
                            System.out.println("\nThis square is already taken!");
                            continue;
                        }

                        //change the number in the square to an X
                        grid[Integer.parseInt(XInput)] = "X";


                        //Adds 1 to the plays, If Plays become 9 there is a draw
                        Plays += 1;


                        //show the grid to the player
                        printgrid();

                        //tells me if someone won
                        IsThereAWinner = didSomeoneWin();
                        someOneWon();


                        //Asks if they want to replay when there is a winner
                        if (Winner == true){
                            replay = Endgame();
                            break;
                        }

                        //change the turn (this also stops the while loop)
                        turn = 2;


                    //If input is a bad integer
                    }
                    else if (XInputInt == 10){
                        System.out.println("Thanks for playing, Hope you liked it!");
                        System.exit(0);
                    }

                    else {
                        System.out.println("\nInvalid input, please enter a number correctly");
                    }
                }

            }




//Computer's turn --------------------------------------------------------------------------------


            //Computer's turn
            if (turn == 2) {

                //Computer plays
                boolean foundGoodInput = false;
                while (!foundGoodInput) {

                    //Generates a random number
                    Random randomgenerator = new Random();
                    int upperbound = 9;
                    int computerInput = randomgenerator.nextInt(upperbound);


                    if (grid[computerInput].equals("X") || grid[computerInput].equals("R")) {
                        //This square is already taken so redo the random number generator (it is fast enough
                        //that doing it multiple time will not affect the rate of the game)
                    }

                    //The random num generator found a good number and inputs it in the grid
                    else {
                        System.out.println("\n---------------------------------------------");
                        //Notifies the user of the play that the computer did
                        System.out.println("Your opponent played in the square number: " + computerInput+"\n");
                        grid[computerInput] = "R";
                        foundGoodInput = true;


                        Plays +=1;
                        turn = 1;
                        printgrid();

                        //checks for winners
                        IsThereAWinner = didSomeoneWin();
                        someOneWon();

                        //If there is a winner, stop the game
                        if (Winner == true){
                            replay = Endgame();
                            break;
                        }
                    }
                }
            }
        }
    }


//-------------------------------------------------------------------------------------------------------------








//-------------------------------------------------------------------------------------------------------------

    //The main method
    //Methods called inside: printgrid(), GameInputs(), ScannerStart(). Rules()
    public static void main(String[] args) {
        //Greets the player
            System.out.println("Hello and welcome to Tic Tac Toe\n");

//While loop to see if the user wants to play, the first time is always true,
//At the end of each game, the user has the option to change it depending on if he wants to play again or not
        while (replay == true) {

            boolean mainLoopVariable = false; //If this turns to true,
                                              //the user has agreed to start the game


            //While loop so that the user can input wrongly as much as he wants
            while (!mainLoopVariable) {

                //Asks the user if he wants to directly start a game or read the rules first
                String Answer = null;
                Answer = ScannerStart(Answer);


                //If he says yes, Start the game directly
                if (Objects.equals(Answer, "y")) {
                    System.out.println("\nGreat lets start!\n");
                    mainLoopVariable = true;//Stop the while loop

                    //If the user wants to replay, all of these variables need to be reset
                    //To do that I just set them here
                    replay = false;
                    IsThereAWinner = 4;
                    turn = 1;
                    Plays = 0;
                    Winner = false;

                    //Makes the grid/ Reset the grid
                    grid = new String[10];
                    for (int i = 0; i < 9; i++) {
                        grid[i] = String.valueOf(i);
                    }

                    //start game method
                    printgrid();
                    System.out.println("\nX has the first go!");
                    GameInputs();


                }


                //If he says no, Show him the rules, then ask him if he wants to start the game
                else if (Objects.equals(Answer, "r")) {
                    System.out.println("\nOk\n");
                    Rules();
                }
                //If the user wants to stop playing
                else if (Objects.equals(Answer, "stop")){
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }

                //If user messes up the input, ask him again
                else {
                    System.out.println("Please enter valid response\n");
                }
            }
        }
        System.out.println("Thanks for playing! Hope you had fun!");
        System.exit(0);
    }

//-------------------------------------------------------------------------------------------------------------

}