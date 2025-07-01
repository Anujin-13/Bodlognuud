import java.util.*;

public class Zurgaa {

    public static String organizingContainers(List<List<Integer>> container) {
        int n = container.size();
        int[] containerSums = new int[n];
        int[] typeSums = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int balls = container.get(i).get(j);
                containerSums[i] += balls;
                typeSums[j] += balls;
            }
        }

        Arrays.sort(containerSums);
        Arrays.sort(typeSums);

        return Arrays.equals(containerSums, typeSums) ? "Possible" : "Impossible";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        for (int t = 0; t < q; t++) {
            int n = scanner.nextInt();
            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(scanner.nextInt());
                }
                container.add(row);
            }

            String result = organizingContainers(container);
            System.out.println(result);
        }

        scanner.close();
    }
}

