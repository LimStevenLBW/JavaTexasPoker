package codingminds.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Hand {
    ArrayList<Card> cards;
    ArrayList<Card> bestHand;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public void AddCard(Card card) {
        cards.add(card);
    }

    public void Sort() {
        Collections.sort(cards);
    }

    public void Evaluate() {
        bestHand = new ArrayList<Card>();

        // Check For Straight Flush
        if (cards.size() == 7)
            bestHand = CheckForStraightFlush(2);
        else if (cards.size() == 6)
            bestHand = CheckForStraightFlush(1);
        else
            bestHand = CheckForStraightFlush(0);

        // Check for Four of a kind

        // Check For Flushes
        if (cards.size() == 7)
            bestHand = CheckForFlush(cards.size() - 1);
        else if (cards.size() == 6)
            bestHand = CheckForFlush(cards.size() - 2);
        else
            bestHand = CheckForFlush(cards.size() - 3);

        // CheckForStraight
        ArrayList<Card> straight = new ArrayList<Card>();
        if (cards.size() == 7)
            bestHand = CheckForStraight(2);
        else if (cards.size() == 6)
            bestHand = CheckForStraight(1);
        else
            bestHand = CheckForStraight(0);

    }

    // Checks 5 cards
    ArrayList<Card> CheckForStraight(int i) {
        ArrayList<Card> straight = new ArrayList<Card>();
        int startingValue = cards.get(i).getValue();

        for (int j = i + 1; j < 4; j++) {
            if (startingValue == cards.get(j).getValue() + 1) {
                straight.add(cards.get(i));
            } else {
                straight.clear();
                return null;
            }
        }

        return straight;
    }

    ArrayList<Card> CheckForStraightFlush(int i) {
        ArrayList<Card> straightFlush = new ArrayList<Card>();
        String suitName = cards.get(i).getSuit();
        int startingValue = cards.get(i).getValue();

        for (int j = i + 1; j < 4; j++) {
            if (startingValue == cards.get(j).getValue() + 1
                    && cards.get(j).getSuit().equals(suitName)) {
                straightFlush.add(cards.get(i));
            } else {
                straightFlush.clear();
                return null;
            }
        }

        return straightFlush;
    }

    ArrayList<Card> CheckForFlush(int i) {
        ArrayList<Card> flush = new ArrayList<Card>();
        String suitName = cards.get(i).getSuit();
        for (int j = 0; j < 4; j++) {
            if (cards.get(i).getSuit() == suitName) {
                flush.add(cards.get(i));
            } else {
                flush.clear();
                return null;
            }
            i--;
        }

        return flush;
    }

    @Override
    public String toString() {
        String contents = "";
        for (int i = 0; i < cards.size(); i++) {
            contents += cards.get(i);
            if (i != cards.size() - 1)
                contents += ", ";
        }

        return contents;
    }
}
