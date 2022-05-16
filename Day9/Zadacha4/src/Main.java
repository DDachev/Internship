import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> kidsHeights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int height = sc.nextInt();
            kidsHeights.add(height);
        }

        int round = 0;

        while (kidsHeights.size() > 1) {
            for (int i = kidsHeights.size() - 1; i > 0; i--) {
                if (kidsHeights.get(i) > kidsHeights.get(i - 1)) {
                    kidsHeights.remove(i);
                }
            }
            round++;
            if (kidsHeights.get(1) < kidsHeights.get(0)) {
                break;
            }
        }
        System.out.println(round);
    }
}