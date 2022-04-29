import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // print square
        System.out.print("Enter size of square: ");
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (i == 0 || i == input - 1) {
                    System.out.print("* ");
                } else if (j == 0 || j == input - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        // print Z
        System.out.print("Enter size of Z: ");
        int input2 = sc.nextInt();
        for (int i = 0; i < input2; i++) {
            for (int j = 0; j < input2; j++) {
                if (i == 0 || i == input2 - 1 || j == input2 - 1 - i) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

//c)  print Tree
        System.out.print("Enter size of tree: ");
        int input3 = sc.nextInt();
        int row = 0;
        for (int i = 0; i < input3; i++) {
            for (int j = 0; j < input3 - i; j++) {
                System.out.print(" ");
            }
            if (i == 0) {
                System.out.println("*");
            } else {
                row += 2;
                for (int k = 0; k <= row; k++) {
                    System.out.print("*");
                }

                System.out.println();
            }
            if (i == input3 - 1) {
                System.out.println("*");
                System.out.println("***");
                break;
            }
        }
    }
}
