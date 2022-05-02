import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter how many numbers you want to enter: ");
        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.print("Enter the numbers: ");
        int max = arr[0] = sc.nextInt();
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("Max number: " + max);

        //second way
        Arrays.sort(arr);
        int max2 = arr[arr.length - 1];
        System.out.println("Max number: " + max2);
    }
}