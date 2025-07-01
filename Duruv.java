import java.util.*;

public class Duruv {

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderCounts = new int[k];

        for (int num : s) {
            remainderCounts[num % k]++;
        }

        int count = Math.min(remainderCounts[0], 1);

        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += Math.max(remainderCounts[i], remainderCounts[k - i]);
            }
        }

        if (k % 2 == 0) {
            count += 1;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            s.add(scanner.nextInt());
        }

        scanner.close();

        int result = nonDivisibleSubset(k, s);
        System.out.println(result);
    }
}

