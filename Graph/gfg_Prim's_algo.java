class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        
        return Prims(V,edges);
        
    }
    
    class Pair{
        int node;
        int wt;
        
        Pair(int a, int b){
            this.node = a;
            this.wt = b;
        }
    }
    
    int Prims(int v, int[][]ed){
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int []e: ed){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }
        
        int res = 0;
        
        boolean []vis = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int wt = pq.peek().wt;
            pq.poll();
            
            if(vis[node])continue;
            
            vis[node] = true;
            res += wt;
            
            for(Pair p : adj.get(node)){
                int currNode = p.node;
                int nwt = p.wt;
                
                if(!vis[currNode]){
                    pq.offer(new Pair(currNode,nwt));
                }
                
            }
        }
        
        return res;
        
    }
}
