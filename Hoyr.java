import java.util.*;

public class Hoyr {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        
        List<Integer> uniqueRanked = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int score : ranked) {
            if (!seen.contains(score)) {
                uniqueRanked.add(score);
                seen.add(score);
            }
        }

        List<Integer> result = new ArrayList<>();
        int index = uniqueRanked.size() - 1;

        for (int pScore : player) {
            while (index >= 0 && pScore >= uniqueRanked.get(index)) {
                index--;
            }
            result.add(index + 2);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int rankedCount = scanner.nextInt();
            List<Integer> ranked = new ArrayList<>();
            for (int i = 0; i < rankedCount; i++) {
                ranked.add(scanner.nextInt());
            }

            int playerCount = scanner.nextInt();
            List<Integer> player = new ArrayList<>();
            for (int i = 0; i < playerCount; i++) {
                player.add(scanner.nextInt());
            }

            List<Integer> result = climbingLeaderboard(ranked, player);
            for (int r : result) {
                System.out.println(r);
            }
        } finally {
            scanner.close();
        }
    }
}

