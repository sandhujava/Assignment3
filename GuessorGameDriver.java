package guessorGame;



import java.util.Scanner;

public class GuessorGameDriver {

    public static void main(String[] args) {
        Umpire umpire = new Umpire();
        System.out.println("Welcome to the game");
        System.out.println("Will you like to play basic or advanced version. Press 1 for basic, 2 for advanced,3 for help");
        Scanner scan = new Scanner(System.in);
        switch(scan.nextInt()) {
            case 1:
                umpire.createGuessorAndPlayer();
                umpire.startGame();
                break;
            case 2:
                umpire.createGuessorAndPlayer();
                umpire.startAdvancedGame();
                break;
            case 3:
                System.out.println("Help Section");
                System.out.println("Basic Version: in this game you will have to guess between 0 and 20 numbers and you will get only 1 chance to guess");
                System.out.println("Advanced Version: in this game you will have to guess between 0 and 200 numbers and you will getmore than 1 chance to guess");
                break;
            default:
                System.out.println("Wrong choice");

        }




    }

}

class Player{
    int playerGuessedNum=-1;

    public int guessPlayerNum() {
        System.out.println("Player guess a number between 0 to 20 ");
        Scanner scan = new Scanner(System.in);
        playerGuessedNum=scan.nextInt();
        if(playerGuessedNum<0 || playerGuessedNum>20) {
            System.out.println("You lost as you did not choose num between 0 and 20");
        }
        return playerGuessedNum;
    }

    public int guessAdvancedPlayerNum(int guessorNum) {
        int count=1;
        do {
            System.out.println("Player guess a number between 0 to 200 ");
            Scanner scan = new Scanner(System.in);
            playerGuessedNum=scan.nextInt();
            if(playerGuessedNum==-1) {
                System.out.println("Better luck next time");
                count=1000;
                return count;
            }
            if(playerGuessedNum<0 || playerGuessedNum>200 ) {
                System.out.println("You lost as you did not choose num between 0 and 200");
                count=1000;
                return count;
            }


            if(playerGuessedNum<guessorNum) {
                System.out.println("Your guess is lower than required, make another Guess or press -1 to give up ");


                count++;
            }
            if(playerGuessedNum>guessorNum) {
                System.out.println("Your guess is greated than required,Make another Guess press -1 to give up ");


                count++;
            }
        }while(playerGuessedNum!=guessorNum ||playerGuessedNum==-1 );

        return count;
    }

}

class Umpire{
    int guessorNum;
    int player1Num;
    int player2Num;
    int player3Num;
    Guessor guessor;
    Player p1 ;
    Player p2 ;
    Player p3 ;
    private int player1Count;
    private int player2Count;
    private int player3Count;

    public void createGuessorAndPlayer() {
        guessor = new Guessor();
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
    }

    public void startAdvancedGame() {
        guessorNum=guessor.guessAdvancedNumber();
        if(guessorNum==-1) {
            return;
        }
        player1Count= p1.guessAdvancedPlayerNum(guessorNum);
        player2Count= p2.guessAdvancedPlayerNum(guessorNum);
        player3Count= p3.guessAdvancedPlayerNum(guessorNum);
        compareAdvanced();

    }

    private void compareAdvanced() {
        if(player1Count==player2Count && player2Count==player3Count) {
            System.out.println("All of you won and guessed the number in "+ player1Count +" counts" );
        }else if(player1Count<player2Count && player1Count<player3Count) {
            System.out.println("Player 1 won and guessed number in  "+ player1Count +" counts" );
        }
        else if(player2Count<player1Count && player2Count<player3Count) {
            System.out.println("Player 2 won and guessed number in  "+ player2Count +" counts" );
        }else {
            System.out.println("Player 3 won and guessed number in  "+ player3Count +" counts" );
        }

    }

    public void startGame() {
        guessorNum=guessor.guessNumber();
        if(guessorNum==-1) {
            return;
        }
        player1Num= p1.guessPlayerNum();
        player2Num= p2.guessPlayerNum();
        player3Num= p3.guessPlayerNum();
        compare();
    }

    private void compare() {
        if(player1Num==guessorNum) {
            if(player1Num==guessorNum && player2Num==guessorNum && player3Num==guessorNum) {
                System.out.println("Lucky Day !!!.. Congrats all 3 of you worn");
            }else if(player2Num==guessorNum) {
                System.out.println("Congrats Player 1 and 2 won");
            }else if( player3Num==guessorNum) {
                System.out.println("Congrats Player 1 and 3 won");
            }else{
                System.out.println("Congrats Player 3 won");
            }
        }else if(player2Num==guessorNum) {
            if(player1Num==guessorNum) {
                System.out.println("Congrats Player 1 and 2 won");
            }else if( player3Num==guessorNum) {
                System.out.println("Congrats Player 2 and 3 won");
            }
            else{
                System.out.println("Congrats Player 2 won");
            }
        }else if(player3Num==guessorNum) {
            if(player1Num==guessorNum) {
                System.out.println("Congrats Player 1 and 3 won");
            }else if( player2Num==guessorNum) {
                System.out.println("Congrats Player 2 and 3 won");
            }else{
              System.out.println("Congrats Player 3 won");


            }
        }else {
            System.out.println("Everyone Lost, try again");
        }

    }

}

class Guessor{
    int guessedNum=-2;

    public int guessNumber() {
        do {
            System.out.println("Enter any guessed number between 0 to 20 or enter -1 to exit");
            Scanner scan = new Scanner(System.in);
            guessedNum=scan.nextInt();
            if(guessedNum==-1) {
                System.out.println("GoodBye");

            }
            else if(guessedNum<0 || guessedNum>20) {
                System.out.println("Invalid number. Choose number between 0 to 20 or enter -1 to exit");
            }
            else {
                return guessedNum;


            }
        }while(guessedNum!=-1);
        return guessedNum;
    }

    public int guessAdvancedNumber() {
        do {
            System.out.println("Enter any guessed number between 0 to 200 or enter -1 to exit");
            Scanner scan = new Scanner(System.in);
            guessedNum=scan.nextInt();
            if(guessedNum==-1) {
                System.out.println("GoodBye");

            }
            else if(guessedNum<0 || guessedNum>200) {
                System.out.println("Invalid number. Choose number between 0 to 200 or enter -1 to exit");
            }
            else {
                return guessedNum;


            }
        }while(guessedNum!=-1);
        return guessedNum;
    }

}