import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers you want to enter: ");

        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.print("Enter the numbers: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int lonelyNumber = 0;
        int count = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                count = 0;
            }

            if (count % 2 != 0) {
                lonelyNumber = arr[i];
            }
        }
        System.out.println(lonelyNumber);
    }
}