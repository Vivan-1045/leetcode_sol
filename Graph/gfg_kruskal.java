package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gfg_kruskal {
    class DisJointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DisJointSet(int n){
            for(int i = 0;i<=n;i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int findPar(int n){
            if(n==parent.get(n)){
                return n;
            }

            int ulp = findPar(parent.get(n));
            parent.set(n,ulp);
            return parent.get(n);
        }

        public void unionBySize(int u, int v){
            int ulp_u = findPar(u);
            int ulp_v = findPar(v);

            if(ulp_u==ulp_v) return;

            if(size.get(ulp_u)<size.get(ulp_v)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
            }else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_v)+size.get(ulp_u));
            }
        }
    }

    public static class Edge implements Comparable<Edge> {
        public int src;
        public int dest;
        public int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge ed){
            return this.wt - ed.wt;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<Edge> ls = new ArrayList<>();


        for(int j = 0;j<edges.length;j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];

            Edge ed = new Edge(u,v,wt);
            ls.add(ed);
        }


        DisJointSet ds = new DisJointSet(V);

        Collections.sort(ls);
        int mstCost = 0;

        for(int i = 0;i<ls.size();i++){
            int wt = ls.get(i).wt;
            int u = ls.get(i).src;
            int v = ls.get(i).dest;

            if(ds.findPar(u) != ds.findPar(v)){
                mstCost += wt;
                ds.unionBySize(u,v);
            }
        }

        return mstCost;
    }
}
