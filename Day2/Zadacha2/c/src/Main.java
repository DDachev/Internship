import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to enter: ");
        int m3= sc.nextInt();
        int[] arr = new int[m3];
        System.out.print("Enter the numbers: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuilder clusters = new StringBuilder();
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                clusters.append(arr[i - 1]).append(" ");
                clusters.append(arr[i]).append(" ");
            }
        }

        String[] resultArr = clusters.toString().split("\\s");
        System.out.println(Arrays.toString(resultArr));
        int clustersCount = 0;
        for (int i = 0; i < resultArr.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (Integer.parseInt(resultArr[i]) == Integer.parseInt(resultArr[j])) {
                    break;
                }
            }
            if (i == j) {
                clustersCount++;
            }
        }
        System.out.println(clustersCount);
    }
}