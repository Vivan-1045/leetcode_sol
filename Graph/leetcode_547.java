package Graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode_547 {
    public static void main(String[] args) {

    }
    public static int numOfProvinces(int[][] adj){
        int max = adj.length;
        List<List<Integer>> adj_list = new ArrayList<>();

        for(int i = 1;i<= max;i++){
            adj_list.add(new ArrayList<>());
        }

        for(int i = 0;i<max;i++){
            for(int j = 0;j<max;j++){
                if(adj[i][j]==1 && i !=j ){
                    adj_list.get(j).add(i);
                    adj_list.get(i).add(j);
                }
            }
        }



        boolean [] visited = new boolean[max+1];
        int provin = 0;
        for(int i = 0;i<max;i++){
            if(visited[i] == false){
                provin++;
                dfs(i,visited,adj_list);
            }
        }
        return provin;
    }

    public static void dfs(int node , boolean[]visit,List<List<Integer>> adj_list){
        visit[node] = true;

        for(int nod : adj_list.get(node)){
            if(!visit[nod]){
                dfs(nod,visit,adj_list);
            }
        }
    }
}
