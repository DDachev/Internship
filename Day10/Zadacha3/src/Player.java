import java.util.ArrayDeque;
import java.util.Deque;

public class Player {
    private Deque<Card> cards = null;
    private final String name;
    private int warsWon = 0;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayDeque<>();
    }

    public String getName() {
        return name;
    }

    public int getWarsWon() {
        return warsWon;
    }
    public void incrementWarsWon() {
        warsWon++;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card getCard() {
        return this.cards.peekLast();
    }

    public void showCards() {
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public Deque<Card> getHand() {
        return cards;
    }
}


