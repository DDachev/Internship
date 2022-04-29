import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to enter: ");
        int m = sc.nextInt();
        int[] arr = new int[m];
        System.out.print("Enter the numbers: ");
        int sumArray = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sumArray += arr[i];
        }
        int sumLeft = 0;
        int sumRight;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            sumLeft += arr[i];
            sumRight = sumArray - sumLeft;
            if (sumLeft == sumRight) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("NO");
        } else {
            System.out.println(index);
        }
    }
}