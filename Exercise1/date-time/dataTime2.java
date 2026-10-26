import java.time.LocalDate;
import java.time.Month;

class dataTime2 {
    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate costumDate = LocalDate.of(2026, 12, 31);
        System.out.println(costumDate);

        int dayOfMonth = now.getDayOfMonth();
        Month month =now.getMonth;
        int year = now.getYear();

        System.out.printf("Day   :" +dayOfMonth);
        System.out.printf("\nMonth :" +month);
        System.out.printf("\nYear  :" +year);
    }
}