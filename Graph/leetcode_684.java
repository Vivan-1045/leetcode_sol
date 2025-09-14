package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = Integer.MIN_VALUE;
        for(int []ed : edges){
            for(int ele : ed){
                n = Math.max(n,ele);
            }
        }


        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []ed : edges){
            int u = ed[0],v = ed[1];

            if(hasCycle(u,v,adj,n)){
                return ed;
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[]{-1,-1};

    }

    boolean hasCycle(int src, int des,List<List<Integer>> adj,int n){
        boolean vis[] = new boolean[n+1];
        vis[src] = true;
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(src);

        while(!qu.isEmpty()){
            int node = qu.poll();

            if(node==des) return true;

            for(int neighbor : adj.get(node)){
                if(!vis[neighbor]){
                    vis[neighbor] = true;
                    qu.offer(neighbor);
                }
            }
        }

        return false;
    }
}
