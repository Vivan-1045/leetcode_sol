package Graph;

import java.util.Arrays;

public class leetcode_1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        return findCit(n,edges,distanceThreshold);
    }
    int findCit(int n,int[][] edg, int th){
        int[][] dist = new int[n][n];

        for(int []a: dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        for(int []ed: edg){
            int u = ed[0];
            int v = ed[1];

            dist[u][v] = ed[2];
            dist[v][u] = ed[2];
        }

        for(int i = 0;i<n;i++){
            dist[i][i] = 0;
        }

        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
                        continue;
                    }

                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }



        int cityCnt = Integer.MAX_VALUE;
        int city = -1;
        for(int i = 0;i<n;i++){
            int currMin = 0;
            for(int j =0;j<n;j++){
                if(dist[i][j]<=th){
                    currMin++;
                }
            }

            if(currMin<cityCnt){
                cityCnt= currMin;
                city = i;
            }
            else if(currMin==cityCnt){
                city = Math.max(city,i);
            }
        }

        return city;
    }
}
