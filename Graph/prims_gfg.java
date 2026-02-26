package Graph;

public class prims_gfg {
    class Pair{
        int node;
        int wt;

        Pair(int n, int w){
            this.node=n;
            this.wt=w;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int ed[]: edges){
            adj.get(ed[0]).add(new Pair(ed[1],ed[2]));
            adj.get(ed[1]).add(new Pair(ed[0],ed[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);
        pq.offer(new Pair(0,0));

        int sum = 0;
        boolean []vis = new boolean[V];

        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int wt = pq.peek().wt;

            pq.remove();

            if(vis[node]) continue;
            vis[node]= true;

            sum += wt;

            for(int i = 0;i<adj.get(node).size();i++){
                int edW = adj.get(node).get(i).wt;
                int nextNode = adj.get(node).get(i).node;

                if(!vis[nextNode]){
                    pq.offer(new Pair(nextNode,edW));
                }
            }
        }

        return sum;
    }
}
