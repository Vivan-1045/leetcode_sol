package Hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_2876 {
    public int[] countVisitedNodes(List<Integer> edges) {
        return solve(edges);
    }

    //Using toposort + cycle detection
    int[] solve(List<Integer> edges){
        int n = edges.size();
        int []res = new int[n];
        int []indeg = new int[n];
        boolean []vis = new boolean[n];

        for(int i = 0;i<n;i++){
            indeg[edges.get(i)]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int node = que.poll();
            int next = edges.get(node);

            indeg[next]--;
            if(indeg[next]==0){
                que.offer(next);
            }
        }

        for(int i = 0;i<n;i++){
            if(indeg[i]>0 && !vis[i]){
                int curr = i;
                int cycleLen = 0;

                while(!vis[curr]){
                    vis[curr] = true;
                    curr = edges.get(curr);
                    cycleLen++;
                }

                curr = i;

                while(res[curr] == 0){
                    res[curr] = cycleLen;
                    curr = edges.get(curr);
                }
            }
        }

        for(int i = 0;i<n;i++){
            if(indeg[i]==0){
                dfs(i,edges,res);
            }
        }

        return res;
    }

    int dfs(int node, List<Integer> ls,int[]res){
        if(res[node]!=0){
            return res[node];
        }

        int next = ls.get(node);
        res[node] = 1 + dfs(next,ls,res);

        return res[node];
    }
}
