package Graph;

import java.util.ArrayList;
import java.util.List;

public class gfg_connected_component {
    class Dis{
        List<Integer> p = new ArrayList<>();
        List<Integer> s = new ArrayList<>();

        Dis(int n){
            for(int i = 0;i<=n;i++){
                p.add(i);
                s.add(1);
            }
        }

        int findPar(int n){
            if(n==p.get(n)){
                return n;
            }

            int ulp = findPar(p.get(n));
            p.set(n,ulp);
            return p.get(n);
        }

        void unionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u==ulp_v){
                return;
            }

            if(s.get(ulp_u)<s.get(ulp_v)){
                p.set(ulp_u,ulp_v);
                s.set(ulp_v,s.get(ulp_u)+s.get(ulp_v));
            }else{
                p.set(ulp_v,ulp_u);
                s.set(ulp_u,s.get(ulp_u)+s.get(ulp_v));
            }
        }
    }

    public int Solve(int n, int[][] edge) {
        // Code here

        Dis ds = new Dis(n);
        int exEd = 0;
        for(int a[] : edge){
            int u = a[0];
            int v = a[1];

            if(ds.findPar(u)==ds.findPar(v)){
                exEd++;
            }else{
                ds.unionBySize(u,v);
            }
        }

        //To find the connected component
        int cc = 0;
        for(int i = 0;i<n;i++){
            if(ds.p.get(i)==i){
                cc++;
            }
        }

        return cc-1<=exEd?cc-1:-1;
    }
}
