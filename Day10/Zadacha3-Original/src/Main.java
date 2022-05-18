import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        int n = Integer.parseInt(sc.nextLine());

        System.out.println();
        String player1Cards = sc.nextLine();
        System.out.println();

        String[] player1CardsArray = player1Cards.split(" ");
        for (String card : player1CardsArray) {
            player1.addCard(createCard(card));
        }

        String player2Cards = sc.nextLine();
        System.out.println();
        String[] player2CardsArray = player2Cards.split(" ");
        for (String card : player2CardsArray) {
            player2.addCard(createCard(card));
        }
        Game.run(player1, player2);
    }

    public static Card createCard(String card) {
        CardRank cardRank = null;
        CardSuit cardSuit = null;
        String[] playerCardsString = card.trim().split(" ");
        for (String cardString : playerCardsString) {
            switch (cardString.charAt(0)) {
                case '2':
                    cardRank = CardRank.TWO;
                    break;
                case '3':
                    cardRank = CardRank.THREE;
                    break;
                case '4':
                    cardRank = CardRank.FOUR;
                    break;
                case '5':
                    cardRank = CardRank.FIVE;
                    break;
                case '6':
                    cardRank = CardRank.SIX;
                    break;
                case '7':
                    cardRank = CardRank.SEVEN;
                    break;
                case '8':
                    cardRank = CardRank.EIGHT;
                    break;
                case '9':
                    cardRank = CardRank.NINE;
                    break;
                case 'T':
                    cardRank = CardRank.TEN;
                    break;
                case 'J':
                    cardRank = CardRank.JACK;
                    break;
                case 'Q':
                    cardRank = CardRank.QUEEN;
                    break;
                case 'K':
                    cardRank = CardRank.KING;
                    break;
                case 'A':
                    cardRank = CardRank.ACE;
                    break;
            }
            switch (cardString.charAt(1)) {
                case 'c':
                    cardSuit = CardSuit.CLUBS;
                    break;
                case 'd':
                    cardSuit = CardSuit.DIAMONDS;
                    break;
                case 'h':
                    cardSuit = CardSuit.HEARTS;
                    break;
                case 's':
                    cardSuit = CardSuit.SPADES;
                    break;
            }
            return new Card(cardSuit, cardRank);
        }
        return null;
    }
}
