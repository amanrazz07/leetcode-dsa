package graph;

import java.util.*;

class Solution_2 {
    static final int MAX_VAL = 1000000;
    static final int MAX_STEPS = 5000;

    // Memoization: store result for each M to avoid recomputation
    static Map<Integer, Integer> cache = new HashMap<>();
    static Set<Integer> fortunate = new HashSet<>(Arrays.asList(
            3, 5, 7, 13, 23, 17, 19, 37,
            61, 67, 71, 47, 107, 59,
            109, 89, 103, 79
    ));

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int N = sc.nextInt();

        // Input array
        int[] A = new int[N];
        for (int i = 0; i < N; i++) A[i] = sc.nextInt();

        // Build segment tree for range maximum queries
        SegmentTree st = new SegmentTree(A);

        int Q = sc.nextInt();
        long totalSum = 0;

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();

            if (type == 0) {
                // Update query
                int idx = sc.nextInt();
                int val = sc.nextInt();
                st.update(idx, val);

            } else {
                // Range max query
                int L = sc.nextInt();
                int R = sc.nextInt();

                int M = st.query(L, R);   // maximum element in range

                // Compute Recamán score
                totalSum += getScore(M);
            }
        }

        // Final result
        System.out.println(totalSum);
    }

    static int getScore(int M) {

        // Return cached result if already computed
        if (cache.containsKey(M)) return cache.get(M);

        Set<Integer> visited = new HashSet<>();

        int current = M;
        visited.add(current);

        int steps = 0;

        for (int n = 1; n <= MAX_STEPS; n++) {

            int nextSub = current - n;
            int next;

            // Prefer subtraction if valid
            if (nextSub > 0 && !visited.contains(nextSub)) {
                next = nextSub;
            } else {
                next = current + n;
            }

            // Count this step
            steps++;

            if (visited.contains(next) || next > MAX_VAL) {
                break;
            }
            visited.add(next);
            current = next;
        }
        int multiplier = fortunate.contains(M) ? 17 : 1;

        int finalScore = steps * multiplier;

        // Store in cache
        cache.put(M, finalScore);

        return finalScore;
    }

    static class SegmentTree {

        int n;
        int[] tree;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 1, 0, n - 1);
        }

        // Build segment tree
        void build(int[] arr, int node, int start, int end) {

            // Leaf node
            if (start == end) {
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end) / 2;

            // Build left and right
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);

            // Store max
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        // Update wrapper
        void update(int idx, int val) {
            update(1, 0, n - 1, idx, val);
        }

        // Point update
        void update(int node, int start, int end, int idx, int val) {

            if (start == end) {
                tree[node] = val;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }

            // Update parent
            tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
        }

        // Query wrapper
        int query(int L, int R) {
            return query(1, 0, n - 1, L, R);
        }

        // Range maximum query
        int query(int node, int start, int end, int L, int R) {

            // No overlap
            if (R < start || end < L) return 0;

            // Complete overlap
            if (L <= start && end <= R) return tree[node];

            int mid = (start + end) / 2;

            // Partial overlap
            return Math.max(
                    query(2 * node, start, mid, L, R),
                    query(2 * node + 1, mid + 1, end, L, R)
            );
        }
    }
}