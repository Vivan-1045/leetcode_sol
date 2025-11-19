package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = numCourses;

        for(int i = 0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adjList.get(v).add(u);
        }

        //Cycle Detection
        boolean [] vis = new boolean[n];
        boolean [] pathVis = new boolean[n];

        for(int i = 0;i<n;i++){
            if(!vis[i]){
                if(isCycle(vis,pathVis,adjList,i)){
                    return new int[]{};
                }
            }
        }


        //Topo
        Stack<Integer> st = new Stack<>();
        Arrays.fill(vis,false);

        for(int i = 0;i<n;i++){
            if(!vis[i]){
                dfs(vis,adjList,i,st);
            }
        }

        int res[] = new int[n];
        int i = 0;
        while(!st.isEmpty()){
            res[i++] = st.pop();
        }

        return res;
    }

    void dfs(boolean[] vis,List<List<Integer>> adjList, int node , Stack<Integer> st){
        vis[node]= true;

        for(int it : adjList.get(node)){
            if(!vis[it]){
                dfs(vis,adjList,it,st);
            }
        }

        st.push(node);
    }

    boolean isCycle(boolean[]vis,boolean[] pathVis, List<List<Integer>> adjList,int node){
        vis[node] = true;
        pathVis[node] = true;

        for(int it : adjList.get(node)){
            if(!vis[it]){
                if(isCycle(vis,pathVis,adjList,it)){
                    return true;
                }
            }
            else if(pathVis[it]){
                return true;
            }
        }

        pathVis[node] = false;

        return false;
    }
}
