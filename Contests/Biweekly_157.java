package Contests;

import java.util.*;

public class Biweekly_157 {
    public static void main(String[] args) {
//       String s = "6357501617";
//        System.out.println(getSum(s));

//        String s1 = "a";
//        System.out.println(maxSub(s1));

        int[][] edges = {{1,2}};
        System.out.println(oddCostPath(edges));
    }
    public static int getSum(String s) {
        Set<Integer> uniquePrimes = new HashSet<>();

        int len = s.length();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String substr = s.substring(i, j);

                if (substr.startsWith("0")) continue;

                try {
                    int num = Integer.parseInt(substr);
                    if (isPrime(num)) {
                        uniquePrimes.add(num);
                    }
                } catch (NumberFormatException e) {
                }
            }
        }

        List<Integer> sortedPrimes = new ArrayList<>(uniquePrimes);
        sortedPrimes.sort(Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < Math.min(3, sortedPrimes.size()); i++) {
            sum += sortedPrimes.get(i);
        }

        return sum;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return true;
        if (number % 2 == 0) return false;

        int sqrt = (int) Math.sqrt(number);
        for (int i = 3; i <= sqrt; i += 2) {
            if (number % i == 0) return false;
        }

        return true;
    }


    public static int maxSub(String s) {
        List<int[]> list = new ArrayList<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 3; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    list.add(new int[]{i, j});
                    break;
                }
            }
        }

        list.sort(Comparator.comparingInt(a -> a[1]));

        int count = 0, lastEnd = -1;
        for (int[] arr : list) {
            if (arr[0] > lastEnd) {
                count++;
                lastEnd = arr[1];
            }
        }

        return count;
    }

    static final int MOD = 1_000_000_007;

    public static int oddCostPath(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> g1 = new ArrayList<>();
        for (int i = 0; i <= n; i++) g1.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g1.get(u).add(v);
            g1.get(v).add(u);
        }

        int[] d = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        int maxDepth = 0;
        int t1 = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int n1 : g1.get(curr)) {
                if (!visited[n1]) {
                    visited[n1] = true;
                    d[n1] = d[curr] + 1;
                    queue.add(n1);
                    if (d[n1] > maxDepth) {
                        maxDepth = d[n1];
                        t1 = n1;
                    }
                }
            }
        }

        int k = d[t1];
        return powMod(2, k - 1, MOD);
    }

    private static int powMod(int base, int exp, int mod) {
        long result = 1, b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % mod;
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }
}
