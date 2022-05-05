import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String date1 = sc.nextLine();
        String date2 = sc.nextLine();

        String[] date1Array = date1.split("\\s");
        String[] date2Array = date2.split("\\s");

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateAfterString = date1Array[0] + "/" + date1Array[1] + "/" + date1Array[2];
        String dateBeforeString = date2Array[0] + "/" + date2Array[1] + "/" + date2Array[2];

        int year1 = Integer.parseInt(date1Array[0]);
        int month1 = Integer.parseInt(date1Array[1]);
        int day1 = Integer.parseInt(date1Array[2]);

        int year2 = Integer.parseInt(date2Array[0]);
        int month2 = Integer.parseInt(date2Array[1]);
        int day2 = Integer.parseInt(date2Array[2]);

        SwiftDate date1Swift = new SwiftDate(year1, month1, day1, dateAfterString);
        SwiftDate date2Swift = new SwiftDate(year2, month2, day2, dateBeforeString);

        System.out.println(date1Swift.getDaysDifference(date2Swift));
        date1Swift.printInfo();
        date2Swift.printInfo();
    }
}