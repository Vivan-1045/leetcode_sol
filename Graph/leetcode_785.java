package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_785 {
    public static void main(String[] args) {
        int[][] arr = {{3},{2,3},{1,3},{0,2,1}};
        System.out.println(isBipartite(arr));
    }
    public static boolean isBipartite(int[][] graph) {

        int[]color = new int[graph.length];
        for(int i = 0;i<graph.length;i++){

            if (color[i] != 0){
                continue;
            }

            Queue<Integer> que = new LinkedList<>();
            que.add(i);
            color[i] = 1;
            color[i] = 1;
            while(!que.isEmpty()){
                int node = que.poll();

                for(int ele : graph[node]){
                    if(color[ele]==0){
                        color[ele] = -color[node];
                        que.add(ele);
                    }else if(color[ele] == color[node]){
                        return false;
                    }
                }

            }

        }
        return true;
    }
}
