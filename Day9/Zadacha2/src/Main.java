import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set1 = fillSetFromInput(sc, n);
        Set<Integer> set2 = fillSetFromInput(sc, m);
        checkForCommonElements(set1, set2);
    }

    public static Set<Integer> fillSetFromInput(Scanner sc, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        return set;
    }

    public static void checkForCommonElements(Set<Integer> set1, Set<Integer> set2) {
        set1.retainAll(set2);
        if (set1.isEmpty()) {
            System.out.println("NO");
        } else {
            printSet(set1);
        }
    }

    public static void printSet(Set<Integer> set) {
        for (Integer integer : set) {
            System.out.print(integer + " ");
        }
    }
}