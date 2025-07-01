import java.util.Scanner;

public class Yos {

    static String[] numbers = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
        "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen",
        "seventeen", "eighteen", "nineteen", "twenty", "twenty one", "twenty two",
        "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
        "twenty eight", "twenty nine", "half"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) {
            return numbers[h] + " o' clock";
        } else if (m == 15 || m == 30) {
            return numbers[m] + " past " + numbers[h];
        } else if (m == 45) {
            return "quarter to " + numbers[h + 1];
        } else if (m < 30) {
            return numbers[m] + (m == 1 ? " minute" : " minutes") + " past " + numbers[h];
        } else {
            int toMinutes = 60 - m;
            return numbers[toMinutes] + (toMinutes == 1 ? " minute" : " minutes") + " to " + numbers[h + 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        System.out.println(timeInWords(h, m));
    }
}

