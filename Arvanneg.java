import java.util.Scanner;

public class Arvanneg {

    public static int surfaceArea(int[][] A) {
        int H = A.length;
        int W = A[0].length;
        int area = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (A[i][j] > 0) {
                    // дээд + доод
                    area += 2;

                    // хойд
                    area += i == 0 ? A[i][j] : Math.max(0, A[i][j] - A[i - 1][j]);
                    // урд
                    area += i == H - 1 ? A[i][j] : Math.max(0, A[i][j] - A[i + 1][j]);
                    // зүүн
                    area += j == 0 ? A[i][j] : Math.max(0, A[i][j] - A[i][j - 1]);
                    // баруун
                    area += j == W - 1 ? A[i][j] : Math.max(0, A[i][j] - A[i][j + 1]);
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int W = scanner.nextInt();

        int[][] A = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        int result = surfaceArea(A);
        System.out.println(result);
    }
}

