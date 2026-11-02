class Solution {
    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(Comparator.comparingLong(p -> p.weight));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            long distance = current.weight;

            if (distance > dist[node]) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {
                int nextNode = neighbor.node;
                long newDistance = distance + neighbor.weight;

                if (newDistance < dist[nextNode]) {
                    dist[nextNode] = newDistance;
                    ways[nextNode] = ways[node];

                    pq.offer(new Pair(nextNode, newDistance));
                }

                else if (newDistance == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }

    public record Pair(int node, long weight) {}
}