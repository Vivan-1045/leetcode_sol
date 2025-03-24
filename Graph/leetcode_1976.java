package Graph;

import java.util.*;

public class leetcode_1976 {
    public static void main(String[] args) {
        int n = 7;
        int[][]roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        System.out.println(maxPath(n,roads));
    }

    public static int MOD = 1_000_000_7;
    public static int maxPath(int n, int[][] roads){
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for (int[] road: roads){
            int u = road[0],v=road[1],t=road[2];
            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u,t});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparing(a ->a[0]));
        long []result = new long[n];
        int []pathCount = new int[n];

        Arrays.fill(result, Integer.MAX_VALUE);
        result[0]= 0;
        pathCount[0]=1;

        pq.offer(new long[]{0,0});
        while (!pq.isEmpty()){
            long[]curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int) curr[1];

            if (currTime>result[currNode]) continue;

            for(int[] ngbr: adj.get(currNode)){
                int adjNode = ngbr[0];
                int time = ngbr[1];

                if (currTime+time<result[adjNode]){
                    result[adjNode] = currTime +time;
                    pathCount[adjNode] = pathCount[currNode];
                    pq.offer(new long[]{result[adjNode],adjNode});
                }else if(currTime +time == result[adjNode]){
                    pathCount[adjNode] = (pathCount[adjNode] + pathCount[currNode])%MOD;
                }
            }
        }
        return pathCount[n-1];
    }

}
