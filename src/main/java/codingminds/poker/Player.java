package codingminds.poker;

public class Player {
    String playerName;
    int playerMoney;
    Hand playerHand;

    public Player(String playerName, int playerMoney) {
        this.playerName = playerName;
        this.playerMoney = playerMoney;
        playerHand = new Hand();
    }

    public void SetHand(Hand playerHand) {
        this.playerHand = playerHand;
    }

    @Override
    public String toString() {
        return playerName + ", Money: " + playerMoney + ", Hand:" + playerHand;
    }

}
