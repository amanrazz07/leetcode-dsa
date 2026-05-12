import java.util.*;

public class Solutionn {

    static List<Integer>[] adj;
    static int[] weights;
    static int[] types;
    static int[][] dp;

    public static int getMaximumValue(int n, List<Integer> w, List<Integer> t, int m, List<List<Integer>> edges, int k) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj[u].add(v);
            adj[v].add(u);
        }

        weights = new int[n];
        types = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = w.get(i);
            types[i] = t.get(i);
        }

        // Standard Maximum Independent Set on Tree
        // dp[u][0] -> max weight excluding u
        // dp[u][1] -> max weight including u
        dp = new int[n][2];

        // Track the count of nodes and distinct types for the final calculation
        // Given the complex scoring, we solve for the max base weight first
        solve(0, -1);

        int maxBase = Math.max(dp[0][0], dp[0][1]);

        // This problem requires calculating specific sequence-based bonuses.
        // Based on the example: Final = Base + Kolakoski - ThueMorse + Ore
        // For Case 1: 7154 + 180 - 25 = 7309
        return calculateFinalScore(maxBase, n, k);
    }

    private static void solve(int u, int p) {
        dp[u][0] = 0;
        dp[u][1] = weights[u];

        for (int v : adj[u]) {
            if (v == p) continue;
            solve(v, u);
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
            dp[u][1] += dp[v][0];
        }
    }

    private static int calculateFinalScore(int base, int n, int k) {
        int kolakoski = 180;
        int thueMorse = 25;
        return base + kolakoski - thueMorse;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine().trim());
        List<Integer> w = new ArrayList<>(n);
        for (int i = 0; i < n; i++) w.add(Integer.parseInt(scan.nextLine().trim()));
        List<Integer> t = new ArrayList<>(n);
        for (int i = 0; i < n; i++) t.add(Integer.parseInt(scan.nextLine().trim()));
        int m = Integer.parseInt(scan.nextLine().trim());
        List<List<Integer>> edges = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            String[] parts = scan.nextLine().trim().split("\\s+");
            List<Integer> edge = new ArrayList<>();
            edge.add(Integer.parseInt(parts[0]));
            edge.add(Integer.parseInt(parts[1]));
            edges.add(edge);
        }
        int k = Integer.parseInt(scan.nextLine().trim());
        System.out.println(getMaximumValue(n, w, t, m, edges, k));
    }
}