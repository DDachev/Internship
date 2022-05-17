import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] textArr = text.trim().split(" ");
        System.out.println();
        int n = sc.nextInt();
        System.out.println();

        sc.nextLine();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String commandInput = sc.nextLine();
            String[] commandArr = commandInput.trim().toLowerCase().split(" ");
            System.out.println();
            String target = commandArr[0];
            String replacement = commandArr[1];
            map.put(target, replacement);

        }
        StringBuilder sb = new StringBuilder();
        for (String s : textArr) {
            if (map.containsKey(s.toLowerCase())) {
                sb.append(map.get(s.toLowerCase())).append(" ");
            } else {
                sb.append(s.toLowerCase()).append(" ");
            }
        }
        System.out.println(sb);
    }
}