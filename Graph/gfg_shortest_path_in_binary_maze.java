package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class gfg_shortest_path_in_binary_maze {
    class Pair{
        int dis;
        int x;
        int y;
        Pair(int wt, int a,int b){
            this.dis=wt;
            this.x=a;
            this.y=b;
        }
    }

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        return shortestDis(grid,source,destination);
    }

    int shortestDis(int [][]arr, int []s, int []d){
        if(s[0]==d[0] && s[1]==d[1]){
            return 0;
        }
        int[][] dist = new int[arr.length][arr[0].length];

        for(int []a: dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        dist[s[0]][s[1]] = 0;

        Queue<Pair> qu = new LinkedList<>();
        qu.offer(new Pair(0,s[0],s[1]));

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        while(!qu.isEmpty()){
            int step = qu.peek().dis;
            int x = qu.peek().x;
            int y = qu.peek().y;
            qu.poll();

            for(int a[] : dir){
                int nx = x + a[0];
                int ny = y + a[1];

                if(nx<arr.length && ny<arr[0].length && nx>=0 && ny>=0 && arr[nx][ny]==1 && dist[nx][ny]>step+1 ){
                    dist[nx][ny] = step+1;
                    if(nx==d[0] && ny == d[1]){
                        return step+1;
                    }
                    qu.offer(new Pair(step+1,nx,ny));
                }
            }
        }
        return -1;
    }
}
