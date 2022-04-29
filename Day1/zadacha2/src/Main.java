import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int sum = 0;
        StringBuilder reverseResult = new StringBuilder();
        StringBuilder evenResult = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int N = sc.nextInt();
            reverseResult.append(N).append(" ");
            if (N % 2 == 0) {
                evenResult.append(N).append(" ");
            }
            sum += N;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Numbers reversed: " + reverseResult.reverse());
        System.out.println("Even numbers: " + evenResult);
    }
}