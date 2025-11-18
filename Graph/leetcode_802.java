package Graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode_802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();

        boolean [] vis = new boolean[n];
        boolean [] pathVis = new boolean[n];
        boolean [] check = new boolean[n];


        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,pathVis,graph,check);
            }
        }

        for(int i = 0;i<n;i++){
            if(check[i]){
                res.add(i);
            }
        }
        return res;
    }

    boolean dfs(int idx,boolean[]vis,boolean[]pathVis,int[][]graph,boolean[]check){
        vis[idx]= true;
        pathVis[idx] = true;


        for(int it : graph[idx]){
            if(!vis[it]){
                if(dfs(it,vis,pathVis,graph,check)){
                    return true;
                }
            }else if(pathVis[it]){
                return true;
            }
        }

        check[idx] = true;
        pathVis[idx] = false;
        return false;
    }
}
