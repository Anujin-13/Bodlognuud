import java.util.Scanner;

public class Doloo {

    public static String encryption(String s) {
        s = s.replaceAll("\\s", "");
        int length = s.length();

        int rows = (int) Math.floor(Math.sqrt(length));
        int cols = (int) Math.ceil(Math.sqrt(length));

        if (rows * cols < length) {
            rows++;
        }

        StringBuilder encrypted = new StringBuilder();

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {
                int index = r * cols + c;
                if (index < length) {
                    encrypted.append(s.charAt(index));
                }
            }
            encrypted.append(" ");
        }

        return encrypted.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        System.out.println(encryption(s));
    }
}
