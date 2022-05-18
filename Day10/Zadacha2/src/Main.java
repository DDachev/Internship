import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //testCompareCards();
        List<Card> cards = createDeckOfCards();
        printDeck(cards);
    }

    public static void printDeck(List<Card> cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println("Total cards: " + cards.size());
    }

    public static List<Card> createDeckOfCards() {
        List<Card> cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                Card card = new Card(suit, rank);
                cards.add(card);
            }
        }
        return cards;
    }

    public static void testCompareCards() {
        Card card1 = new Card(Card.Suit.CLUBS, Card.Rank.FOUR);
        Card card2 = new Card(Card.Suit.HEARTS, Card.Rank.SIX);
        Card card3 = new Card(Card.Suit.HEARTS, Card.Rank.SIX);

        if (card1.compareTo(card2) > 0) {
            System.out.println(card1 + " is greater than " + card2);
        } else if (card1.compareTo(card2) < 0) {
            System.out.println(card2 + " is greater than " + card1);
        }
        if (card2.equals(card3)) {
            System.out.println(card2 + " is equal to " + card3);
        }
    }
}