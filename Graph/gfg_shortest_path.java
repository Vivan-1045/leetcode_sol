package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class gfg_shortest_path {
        class Pair{
            int a;
            int b;
            Pair(int x, int y){
                this.a=x;
                this.b=y;
            }
        }

        public int[] shortestPath(int V, int E, int[][] edges) {
            // Code here

            List<List<Pair>> adjList = new ArrayList<>();
            for(int i = 0;i<V;i++){
                List<Pair> ls = new ArrayList<>();
                adjList.add(ls);
            }

            for(int a[] : edges){
                int u = a[0];
                int v = a[1];
                int wt = a[2];

                adjList.get(u).add(new Pair(v,wt));
            }

            Stack<Integer> st = new Stack<>();
            boolean[]vis = new boolean[V];

            for(int i = 0;i<V;i++){
                if(!vis[i]){
                    dfs(adjList,i,vis,st);
                }
            }


            int []dist = new int[V];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[0] = 0;

            while(!st.isEmpty()){
                int node = st.pop();


                for(Pair pair : adjList.get(node)){
                    int v = pair.a;
                    int wt = pair.b;

                    if(dist[node] != Integer.MAX_VALUE && dist[node]+wt < dist[v]){
                        dist[v] = dist[node]+wt;
                    }
                }

            }

            for(int i = 0;i<V;i++){
                if(dist[i] == Integer.MAX_VALUE){
                    dist[i] = -1;
                }
            }

            return dist;

        }

        void dfs(List<List<Pair>> adjList, int node, boolean[]vis, Stack<Integer> st){
            vis[node] = true;

            for(Pair pair : adjList.get(node)){
                int it = pair.a;
                if(!vis[it]){
                    dfs(adjList,it,vis,st);
                }
            }

            st.push(node);
        }
}
