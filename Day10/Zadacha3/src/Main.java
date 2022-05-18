import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> fullDeck = createDeckOfCards();

        Player player1 = new Player("Dacho");
        Player player2 = new Player("Ivo");
        giveCardsToPlayers(fullDeck, player1, player2);
        Game.run(player1, player2);
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

    public static void giveCardsToPlayers(List<Card> cards, Player player1, Player player2) {
        Collections.shuffle(cards);
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.addCard(cards.get(i));
            } else {
                player2.addCard(cards.get(i));
            }
        }
    }
}