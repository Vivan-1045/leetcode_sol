package Graph;

import java.util.Arrays;

public class gfg_Bellman_ford_algo {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        return distArray(V,edges,src);
    }

    int[] distArray(int V, int [][] edges,int src){

        int[] dist = new int[V];
        Arrays.fill(dist,100000000);
        dist[src] = 0;

        for(int i= 0;i<V-1;i++){
            for(int []ed : edges){
                int u = ed[0];
                int v = ed[1];
                int wt = ed[2];

                if( dist[u] != 100000000 && dist[u]+wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        //To detect negative cycle
        for(int[] a : edges){
            int u =a[0];
            int v = a[1];
            int wt = a[2];

            if(dist[u] != 100000000 && dist[u]+wt<dist[v]){
                int []temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }
}
