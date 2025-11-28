package Graph;

import java.util.*;

public class leetcode_787 {
    class Pair{
        int node;
        int cost;
        Pair(int a, int b){
            this.node=a;
            this.cost=b;
        }
    }

    class Tuple{
        int stop;
        int node;
        int cost;

        Tuple(int a, int b, int c){
            this.stop=a;
            this.node=b;
            this.cost=c;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return cheapestCost(n,flights,src,dst,k);
    }
    int cheapestCost(int n, int [][] arr, int src, int dst, int k){
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int []a : arr){
            adj.get(a[0]).add(new Pair(a[1],a[2]));
        }

        int []dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[src] = 0;

        Queue<Tuple> qu = new LinkedList<>();
        qu.offer(new Tuple(0,src,0));

        while(!qu.isEmpty()){
            int stop = qu.peek().stop;
            int node = qu.peek().node;
            int cost = qu.peek().cost;
            qu.poll();

            if(stop>k){
                continue;
            }

            for(Pair pair : adj.get(node)){
                int it = pair.node;
                int currCst = pair.cost;

                if(dist[it]>cost+currCst){
                    dist[it] = cost + currCst;
                    qu.offer(new Tuple(stop+1,it,cost+currCst));
                }
            }
        }


        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
