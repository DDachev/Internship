//Задача 1:
//print a matrix in the following pattern:
//input: 4
//output:
//1 8 9 16
//2 7 10 15
//3 6 11 14
//4 5 12 13

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        int counter = 1;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                // If current column is even, print in normal order
                if (j % 2 == 0) {
                    matrix[i][j] = counter;
                    counter++;

                } else {
                    // If current column is odd, print  in reverse order

                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}