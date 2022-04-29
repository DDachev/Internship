import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to enter and which number to look for: ");
        int[] input = new int[2];

        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }

        int m = input[0];
        int numberToLookFor = input[1];

        int[] arr2 = new int[m];
        System.out.print("Enter the numbers: ");

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = sc.nextInt();
        }

        Arrays.sort(arr2);
        System.out.println("The sorted array is: " + Arrays.toString(arr2));

        int index = Arrays.binarySearch(arr2, numberToLookFor);

        if (index >= 0) {
            System.out.println(index);
        } else {
            System.out.println("NO");
        }
    }
}