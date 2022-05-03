import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Map<Character, Integer> counterMap = new HashMap<>();

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (counterMap.containsKey(c)) {
                counterMap.put(c, counterMap.get(c) + 1);
            } else {
                counterMap.put(c, 1);
            }
        }

        TreeMap<Character, Integer> sortedMap = new TreeMap<>(counterMap);

        for (char c : sortedMap.keySet()) {
            System.out.println(c + ":" + sortedMap.get(c));
        }
    }
}