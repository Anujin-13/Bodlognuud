import java.util.*;

public class Arav {

    public static String gridSearch(List<String> G, List<String> P) {
        int R = G.size();
        int C = G.get(0).length();
        int r = P.size();
        int c = P.get(0).length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean match = true;
                for (int k = 0; k < r; k++) {
                    if (!G.get(i + k).substring(j, j + c).equals(P.get(k))) {
                        match = false;
                        break;
                    }
                }
                if (match) return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int test = 0; test < t; test++) {
            String[] RC = scanner.nextLine().split(" ");
            int R = Integer.parseInt(RC[0]);
            int C = Integer.parseInt(RC[1]);

            List<String> G = new ArrayList<>();
            for (int i = 0; i < R; i++) {
                G.add(scanner.nextLine());
            }

            String[] rc = scanner.nextLine().split(" ");
            int r = Integer.parseInt(rc[0]);
            int c = Integer.parseInt(rc[1]);

            List<String> P = new ArrayList<>();
            for (int i = 0; i < r; i++) {
                P.add(scanner.nextLine());
            }

            System.out.println(gridSearch(G, P));
        }

        scanner.close();
    }
}
