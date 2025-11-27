package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class gfg_dijkastra {
    class Pair{
        int dis;
        int node;
        Pair(int a, int b){
            this.dis = a;
            this.node = b;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here

        List<List<Pair>> adj = new ArrayList<>();

        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int a[]:edges){
            int u = a[0];
            int v = a[1];
            int wt = a[2];

            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }

        return minDist(V,adj,src);

    }

    int []minDist(int V, List<List<Pair>> adj, int src){
        int[]dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.dis-y.dis);
        pq.offer(new Pair(0,src));


        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dis = pq.peek().dis;
            pq.poll();

            for(Pair pair : adj.get(node)){
                int currNode = pair.node;
                int currDis = pair.dis;

                if(dist[currNode]>dis+currDis){
                    dist[currNode] = dis+currDis;
                    pq.offer(new Pair(dist[currNode],currNode));
                }
            }
        }

        return dist;

    }
}
