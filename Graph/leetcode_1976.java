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



    //Another Way
    class Pair{
        long dis;
        int node;
        Pair(long a, int b){
            this.dis=a;
            this.node=b;
        }
    }

    public int countPaths(int n, int[][] roads) {
        return totalPath(n,roads);
    }
    int totalPath(int n, int [][] road){
        int[] ways = new int[n];
        ways[0]= 1;

        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []a : road){
            int u = a[0];
            int v = a[1];
            adj.get(u).add(new Pair(a[2],v));
            adj.get(v).add(new Pair(a[2],u));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dis, b.dis));
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            long dis = pq.peek().dis;
            int node = pq.peek().node;
            pq.poll();

            if(dist[node]<dis){
                continue;
            }

            for(Pair pair : adj.get(node)){
                int currNode = pair.node;
                long currDis = pair.dis;

                if(dist[currNode]> dis+currDis){
                    dist[currNode] = dis + currDis;
                    ways[currNode] = ways[node];
                    pq.offer(new Pair(dis+currDis,currNode));
                }
                else if(dist[currNode]==dis+currDis){
                    ways[currNode] = (ways[node]+ways[currNode])%MOD;
                }
            }
        }

        return ways[n-1];
    }

}
