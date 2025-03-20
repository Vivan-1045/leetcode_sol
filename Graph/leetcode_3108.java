package Graph;

import java.util.Arrays;

public class leetcode_3108 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edge = {{0,1,7},{1,3,7},{1,2,1}};
        int[][] query = {{0,3},{3,4}};
        System.out.println(Arrays.toString(minimumCost(n,edge,query)));
    }
    public static int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] cost = new int[n];
        Arrays.fill(cost, -1);
        int[] result = new int[query.length];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            int parent_u = find(u, parent);
            int parent_v = find(v, parent);

            if (parent_u != parent_v) {
                cost[parent_u] &= cost[parent_v];
                union(parent_u, parent_v, parent);
            }

            cost[parent_u] &= w;
        }

        for (int i = 0; i < query.length; i++) {
            int s = query[i][0];
            int t = query[i][1];

            int p1 = find(s, parent);
            int p2 = find(t, parent);

            if (s == t)
                result[i] = 0;
            else if (p1 != p2)
                result[i] = -1;
            else
                result[i] = cost[p1];
        }

        return result;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }

    private static void union(int x, int y, int[] parent) {
        parent[y] = x;
    }
}
