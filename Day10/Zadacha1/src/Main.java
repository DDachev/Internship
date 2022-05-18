public class Main {
    public static void main(String[] args) {
        for (CardSuit suit : CardSuit.values()) {
            System.out.print(suit + " ");
        }
        System.out.println();
        for (CardRank rank : CardRank.values()) {
            System.out.print(rank + " ");
        }
    }
}