import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> kidsHeights = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            kidsHeights.add(height);
        }

        int rounds = 0;
        boolean removed = false;

        while (true) {
            for (int i = kidsHeights.size() - 1; i > 0; i--) {
                if (kidsHeights.get(i) > kidsHeights.get(i - 1)) {
                    kidsHeights.remove(i);
                    removed = true;
                }
            }

            if (!removed) {
                break;
            }
            rounds++;
            removed = false;
        }
        System.out.println(rounds);

    }
}