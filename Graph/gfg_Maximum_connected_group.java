package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class gfg_Maximum_connected_group {
    class Dis{
        List<Integer> s = new ArrayList<>();
        List<Integer> p = new ArrayList<>();

        Dis(int n){
            for(int i = 0;i<n;i++){
                s.add(1);
                p.add(i);
            }
        }

        int findPar(int n){
            if(n== p.get(n)){
                return n;
            }

            int ulp = findPar(p.get(n));
            p.set(n,ulp);
            return p.get(n);
        }

        void unionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u==ulp_v)return;
            if(s.get(ulp_u)<s.get(ulp_v)){
                p.set(ulp_u,ulp_v);
                s.set(ulp_v,s.get(ulp_v)+s.get(ulp_u));
            }else{
                p.set(ulp_v,ulp_u);
                s.set(ulp_u,s.get(ulp_u)+s.get(ulp_v));
            }
        }
    }

    public int MaxConnection(int grid[][]) {
        // Your code here

        int[]dr = {0,1,0,-1};
        int[]dc = {-1,0,1,0};

        int n = grid.length;
        Dis ds = new Dis(n*n);

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==0)continue;
                for(int idx=0;idx<4;idx++){
                    int nr = i + dr[idx];
                    int nc = j + dc[idx];

                    if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                        int nodeNo = i*n+j;
                        int adjNodeNo = nr*n+nc;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }


        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==1)continue;
                Set<Integer> st = new HashSet<>();
                for(int idx =0;idx<4;idx++){
                    int nr = i + dr[idx];
                    int nc = j + dc[idx];

                    if(nr>=0 && nc>=0 && nr<n && nc<n){
                        if(grid[nr][nc]==1){
                            st.add(ds.findPar(nr*n+nc));
                        }
                    }
                }

                int totalSize = 0;
                for(int ele :st){
                    totalSize += ds.s.get(ele);
                }

                max = Math.max(max,totalSize+1);
            }
        }


        for(int cellNo = 0;cellNo<n*n;cellNo++){
            max = Math.max(max,ds.s.get(ds.findPar(cellNo)));
        }


        return max;
    }
}
