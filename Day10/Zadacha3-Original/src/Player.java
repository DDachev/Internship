import java.util.ArrayDeque;
import java.util.Deque;

public class Player {
    private Deque<Card> cards = new ArrayDeque<>();
    private int warsWon = 0;
    private String name;


    public Player(String name) {
        this.name = name;
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
        cards.addLast(card);
    }

    public Card getCard() {
        return this.cards.peekFirst();
    }

    public void showCards() {
        System.out.println(this.getName() + " has " + this.getHand().size() + " cards:");
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public Deque<Card> getHand() {
        return cards;
    }
}


