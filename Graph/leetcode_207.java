package Graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] arr : prerequisites){
            int r = arr[0];
            int c = arr[1];

            adjList.get(c).add(r);
        }

        boolean vis[] = new boolean[numCourses];
        boolean pathVis[] = new boolean[numCourses];

        for(int i = 0;i<numCourses;i++){
            if(!vis[i]){
                if(dfs(adjList,vis,pathVis,i)){
                    return false;
                }
            }
        }

        return true;
    }

    boolean dfs(List<List<Integer>> adjList , boolean [] vis, boolean []pathVis, int idx){
        vis[idx] = true;
        pathVis[idx] = true;

        for(int it : adjList.get(idx)){
            if(!vis[it]){
                if(dfs(adjList,vis,pathVis,it)){
                    return true;
                }
            }
            else if(pathVis[it]){
                return true;
            }
        }

        //Backtrack
        pathVis[idx] = false;

        return false;
    }
}
