import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int warsCount;
    private static int roundsCount = 1;
    private static int numberOfDraws;

    public static void run(Player player1, Player player2) {

        while (player1.getHand().size() > 0 && player2.getHand().size() > 0) {

            Card player1Card = player1.getCard();
            Card player2Card = player2.getCard();
            List<Card> player1WarCards = new ArrayList<>();
            List<Card> player2WarCards = new ArrayList<>();
            gameLog("Round " + roundsCount);
            gameLog(player1.getName() + " has " + player1Card + " and " + player2.getName() + " has " + player2Card);
            if (player1Card != null && player2Card != null) {

                if (player1Card.compareTo(player2Card) > 0) {
                    player1.getHand().addLast(player1Card);
                    player1.getHand().addLast(player2Card);
                    player1.getHand().removeFirst();
                    player2.getHand().removeFirst();
                    gameLog(player1.getName() + " wins the round");
                } else if (player1Card.compareTo(player2Card) < 0) {
                    player2.getHand().addLast(player2Card);
                    player2.getHand().addLast(player1Card);
                    player2.getHand().removeFirst();
                    player1.getHand().removeFirst();
                    gameLog(player2.getName() + " wins the round");
                }
                if (player1Card.equals(player2Card)) {
                    player1.getHand().removeFirst();
                    player2.getHand().removeFirst();
                    gameLog("War!");
                    warsCount++;
                    playWar(player1, player2, player1WarCards, player2WarCards);
                }
            }
            roundsCount++;
            player1.showCards();
            player2.showCards();
        }
        printEndText(player1, player2);
    }

    public static void printEndText(Player player1, Player player2) {
        System.out.println("Game over");
        if (player1.getHand().size() == 0 && player2.getHand().size() == 0) {
            gameLog("DRAW - Both players have no cards left");
        } else if (player1.getHand().size() == 0) {
            System.out.println(player2.getName() + " WINS THE GAME!");
        } else if (player2.getHand().size() == 0) {
            System.out.println(player1.getName() + " WINS THE GAME!");
        }

        gameLog("The game ends in " + roundsCount + " rounds");
        System.out.println("Total number of wars: " + warsCount);
        System.out.println("Total number of war draws: " + numberOfDraws);
        System.out.println(player1.getName() + " won " + player1.getWarsWon() + " wars");
        System.out.println(player2.getName() + " won " + player2.getWarsWon() + " wars");

    }

    private static void playWar(Player player1, Player player2, List<Card> player1WarCards, List<Card> player2WarCards) {
        if (player1.getHand().size() > 0 && player2.getHand().size() > 0) {
            int player1Score = 0;
            int player2Score = 0;

            player1.showCards();
            player2.showCards();
            if (player1.getHand().size() >= 3 && player2.getHand().size() >= 3) {

                for (int i = 0; i < 3; i++) {
                    Card player1Card = player1.getHand().removeFirst();
                    player1WarCards.add(player1Card);
                    player1Score += player1Card.getValue();

                    Card player2Card = player2.getHand().removeFirst();
                    player2WarCards.add(player2Card);
                    player2Score += player2Card.getValue();
                }

            } else if (player1.getHand().size() < 3 && player2.getHand().size() >= 3) {
                gameLog(player1.getName() + " has less than 3 cards");
                for (Card card : player1.getHand()) {
                    player1.getHand().removeFirst();
                    player1WarCards.add(card);
                    player1Score += card.getValue();
                }
                for (int i = 0; i < 3; i++) {
                    Card player2Card = player2.getHand().removeFirst();
                    player2WarCards.add(player2Card);
                    player2Score += player2Card.getValue();
                }

            } else if (player1.getHand().size() >= 3 && player2.getHand().size() < 3) {
                gameLog(player2.getName() + " has less than 3 cards");
                for (int i = 0; i < 3; i++) {
                    Card player1Card = player1.getHand().removeFirst();
                    player1WarCards.add(player1Card);
                    player1Score += player1Card.getValue();
                }
                for (Card card : player2.getHand()) {
                    player2.getHand().removeFirst();
                    player2WarCards.add(card);
                    player2Score += card.getValue();
                }
            }


            if (player1Score == player2Score) {
                numberOfDraws++;
                gameLog("Draw! Another War!");
                if (player1.getHand().size() == 0 && player2.getHand().size() == 0) {
                    return;
                }
                playWar(player1, player2, player1WarCards, player2WarCards);
            } else {
                getWarWinner(player1, player2, player1Score, player2Score);
                if (player1Score > player2Score) {
                    player1WarCards.addAll(player2WarCards);
                    for (Card card : player1WarCards) {
                        player1.addCard(card);
                    }
                    player1WarCards.clear();
                } else {
                    player2WarCards.addAll(player1WarCards);
                    for (Card card : player2WarCards) {
                        player2.addCard(card);
                    }
                    player2WarCards.clear();
                }
            }
        }
    }

    public static void getWarWinner(Player player1, Player player2, int player1Score, int player2Score) {
        gameLog(player1.getName() + " got " + player1Score);
        gameLog(player2.getName() + " got " + player2Score);
        if (player1Score > player2Score) {
            gameLog(player1.getName() + " wins the war");
            player1.incrementWarsWon();
        } else {
            gameLog(player2.getName() + " wins the war");
            player2.incrementWarsWon();
        }
    }

    public static void gameLog(String message) {
        System.out.println(message);
    }
}
