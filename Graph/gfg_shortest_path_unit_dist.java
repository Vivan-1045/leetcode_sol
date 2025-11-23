package Graph;

import java.util.*;

public class gfg_shortest_path_unit_dist {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        return shortPath(V,edges,src);
    }

    int [] shortPath(int V, int [][] edges , int src){
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int []ed:edges){
            adj.get(ed[0]).add(ed[1]);
            adj.get(ed[1]).add(ed[0]);
        }

        int dist[] = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(src);

        while(!que.isEmpty()){
            int node = que.poll();

            for(int it : adj.get(node)){
                if(dist[node]+1<dist[it]){
                    dist[it] = dist[node]+1;
                    que.add(it);
                }
            }
        }
    
        for(int i = 0;i<V;i++){
            if(dist[i]==Integer.MAX_VALUE){
                dist[i]=-1;
            }
        }

        return dist;
    }
}
