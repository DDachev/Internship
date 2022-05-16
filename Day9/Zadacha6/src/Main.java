import java.util.Scanner;
import java.util.Stack;

//Напишете програма, която да декларира Stack и да поддържа следните операции:
//    • PUSH <number> - добавя число в стека
//    • POP – изважда последното число от стека
//    • MAX – намира най-голямото число в стека и го отпечатва (не го изважда)
//
//Програмата чете от стандартния вход и приключва изпълнението си, когато е
// въведена командата „END”. На стандартния изход при всяка команда POP и MAX
// се отпечатва съответното число (извадено или намерено), а след края се отпечатва
// числата, останали в стека, разделени с интервал.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        while (true) {
            String command = sc.next().trim();
            if (command.equalsIgnoreCase("END")) {
                break;
            } else if (command.equals("PUSH")) {
                stack.push(sc.nextInt());

            } else if (command.equals("POP")) {
                System.out.println(stack.pop());

            } else if (command.equals("MAX")) {
                int max = Integer.MIN_VALUE;
                for (Integer integer : stack) {
                    if (integer > max) {
                        max = integer;
                    }
                }
                System.out.println(max);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}