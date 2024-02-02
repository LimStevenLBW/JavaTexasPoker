package codingminds.poker;

import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame {
    int bigBlind;
    int smallBlind;

    Deck myDeck;
    Scanner scanner;
    ArrayList<Player> playerList;

    public PokerGame() {
        playerList = new ArrayList<>();
        scanner = new Scanner(System.in);
        myDeck = new Deck();
        myDeck.Shuffle();
    }

    public void Setup() {
        /*
         * System.out.println("What is your name?");
         * String playerName = scanner.nextLine();
         * 
         * System.out.println("How many opponents do you want?");
         * int opponentCount = scanner.nextInt();
         * scanner.nextLine();
         * 
         * System.out.println("What is the starting bank for players");
         * int startingMoney = scanner.nextInt();
         * scanner.nextLine();
         * 
         * System.out.println("What is the starting blind");
         * bigBlind = scanner.nextInt();
         * scanner.nextLine();
         * smallBlind = bigBlind / 2;
         */

        // Test
        int opponentCount = 1;
        String playerName = "";
        int startingMoney = 1000;

        for (int i = 0; i < opponentCount + 1; i++) {

            if (i == 0)
                playerList.add(new Player(playerName, startingMoney));
            else {
                playerName = "Computer " + i;
                playerList.add(new Player(playerName, startingMoney));
            }

        }
    }

    public void StartGame() {
        for (int i = 0; i < playerList.size(); i++) {
            Hand newHand = myDeck.GetNewHand();
            playerList.get(i).SetHand(newHand);
        }
    }

    public void PrintAllPlayerStatus() {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i));
        }
    }
}
