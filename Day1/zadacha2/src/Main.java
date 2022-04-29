import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int sum = 0;
        int[] N = new int[M];
        int[] reverseArr = new int[M];
        StringBuilder reverseResult = new StringBuilder();
        StringBuilder evenResult = new StringBuilder();

        for (int i = 0; i < M; i++) {
            N[i] = sc.nextInt();
            reverseArr[i] = N[i];
            sum += N[i];

            if (N[i] % 2 == 0) evenResult.append(N[i]).append(" ");
        }

        for (int i = M - 1; i >= 0; i--) reverseResult.append(reverseArr[i]).append(" ");

        System.out.println("Sum: " + sum);
        System.out.println("Numbers reversed: " + reverseResult);
        System.out.println("Even numbers: " + evenResult);
    }
}