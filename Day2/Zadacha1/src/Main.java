import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //a)
        int[] array = {5, 9, 11, 3, 6, 4, 7};
        for (int arrayElement : array) {
            System.out.println(arrayElement);
        }

        //b)

        int n = sc.nextInt();
        int[] array2 = new int[n];
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            array2[i] = sc.nextInt();
        }
        for (int arrayElement : array2) {
            result.append(arrayElement).append(", ");
        }
        System.out.println(result.substring(0, result.lastIndexOf(", ")));

        //c)
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));
        }

        //d)
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}