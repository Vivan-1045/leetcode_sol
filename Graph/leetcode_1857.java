package Graph;

import java.util.*;

public class leetcode_1857 {

    public static void main(String[] args) {

    }

    public static int longPth(String colors,int[][] edges){
        int N = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[N];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[][] t = new int[N][26];

        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                t[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int answer = 0;
        int countNodes = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            countNodes++;

            for (int i = 0; i < 26; i++) {
                answer = Math.max(answer, t[u][i]);
            }

            List<Integer> neighbors = adj.getOrDefault(u, new ArrayList<>());
            for (int v : neighbors) {
                for (int i = 0; i < 26; i++) {
                    int val = t[u][i] + (colors.charAt(v) - 'a' == i ? 1 : 0);
                    t[v][i] = Math.max(t[v][i], val);
                }

                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return countNodes < N ? -1 : answer;
    }

}
