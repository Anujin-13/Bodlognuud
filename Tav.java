import java.util.*;

public class Tav {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int up = n - r_q;
        int down = r_q - 1;
        int right = n - c_q;
        int left = c_q - 1;
        int upRight = Math.min(up, right);
        int upLeft = Math.min(up, left);
        int downRight = Math.min(down, right);
        int downLeft = Math.min(down, left);

        for (List<Integer> obs : obstacles) {
            int r = obs.get(0);
            int c = obs.get(1);

            if (c == c_q) {
                if (r > r_q) up = Math.min(up, r - r_q - 1);
                else if (r < r_q) down = Math.min(down, r_q - r - 1);
            } else if (r == r_q) {
                if (c > c_q) right = Math.min(right, c - c_q - 1);
                else if (c < c_q) left = Math.min(left, c_q - c - 1);
            } else if (Math.abs(r - r_q) == Math.abs(c - c_q)) {
                if (r > r_q && c > c_q) upRight = Math.min(upRight, r - r_q - 1);
                else if (r > r_q && c < c_q) upLeft = Math.min(upLeft, r - r_q - 1);
                else if (r < r_q && c > c_q) downRight = Math.min(downRight, r_q - r - 1);
                else if (r < r_q && c < c_q) downLeft = Math.min(downLeft, r_q - r - 1);
            }
        }

        return up + down + right + left + upRight + upLeft + downRight + downLeft;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: n, k, queen's row and column
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int r_q = scanner.nextInt();
        int c_q = scanner.nextInt();

        List<List<Integer>> obstacles = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Integer> obs = new ArrayList<>();
            obs.add(scanner.nextInt());
            obs.add(scanner.nextInt());
            obstacles.add(obs);
        }

        scanner.close();

        int result = queensAttack(n, k, r_q, c_q, obstacles);
        System.out.println(result);
    }
}

