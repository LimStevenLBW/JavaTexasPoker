package codingminds.poker;

public class Main {
    public static void main(String[] args) {

        // System.out.println("Select Your Game");
        // System.out.println("1. BlackJack");
        // System.out.println("2. Texas Hold Em'");

        PokerGame game = new PokerGame();
        game.Setup();
        game.StartGame();
        game.PrintAllPlayerStatus();

        /*
         * Player player1 = new Player("Me", 1000);
         * Player player2 = new Player("Bob", 1000);
         * 
         * System.out.println("Welcome to Texas Hold Em");
         * System.out.println("");
         */
        // myDeck.Shuffle();
        // myDeck.PrintCards();

        // Card drawnCard = myDeck.DrawCard();
        // System.out.println("\n" + drawnCard);

    }
}