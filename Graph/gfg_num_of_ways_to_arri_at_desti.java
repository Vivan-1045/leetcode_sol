package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class gfg_num_of_ways_to_arri_at_desti {
    public int countPaths(int V, int[][] edges) {
        // code here
        return totalPath(V,edges);
    }

    class Pair{
        int dis;
        int node;
        Pair(int a, int b){
            this.dis=a;
            this.node=b;
        }
    }

    int MOD = 1000000007;
    int totalPath(int n, int [][] road){
        int[] ways = new int[n];
        ways[0]= 1;

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
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

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> a.dis-b.dis);
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            int dis = pq.peek().dis;
            int node = pq.peek().node;
            pq.poll();

            for(Pair pair : adj.get(node)){
                int currNode = pair.node;
                int currDis = pair.dis;

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
