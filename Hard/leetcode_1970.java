package Hard;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1970 {
    int n = 0;
    int m = 0;

    static class Pair{
        int i;
        int j;
        Pair(int a, int b){
            this.i=a;
            this.j=b;
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        n = row;
        m = col;
        return lastDay(cells);
    }

    int lastDay(int [][]cells){
        int lastDay = 0;

        int l = 0;
        int r= cells.length;

        while(l<=r){
            int m = l + (r-l)/2;

            if(canReach(cells,m)){
                lastDay = m+1;
                l = m+1;
            }else{
                r = m-1;
            }
        }

        return lastDay;
    }


    boolean canReach(int[][]cells,int idx){
        int [][] currMat = new int[n][m];
        for(int i =0;i<=idx;i++){
            int x = cells[i][0]-1;
            int y = cells[i][1]-1;

            currMat[x][y] = 1;
        }

        for(int k = 0;k<m;k++){
            if(currMat[0][k]==0 && BFS(currMat,0,k)){ //here you can either call DFS or BFS
                return true;
            }
        }

        return false;
    }

    int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    //Using DFS
    boolean DFS(int[][] arr, int i, int j){
        if(i>=n || j>=m || i<0 || j<0 || arr[i][j]==1){
            return false;
        }

        if(i==n-1){
            return true;
        }

        arr[i][j] = 1;

        for(int[] d : dir){
            int n_i = i + d[0];
            int n_j = j + d[1];

            if(DFS(arr,n_i,n_j)){
                return true;
            }
        }

        return false;
    }



    //Using BFS
    boolean BFS(int[][] arr, int x, int y){
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(x, y));

        arr[x][y] = 1;

        while(!que.isEmpty()){
            Pair p = que.poll();
            int i = p.i;
            int j = p.j;

            if(i==n-1){
                return true;
            }
            for(int []d: dir){
                int n_i = i + d[0];
                int n_j = j + d[1];

                if(n_i<n && n_j<m && n_i>=0 && n_j>=0 && arr[n_i][n_j]==0){
                    que.offer(new Pair(n_i, n_j));
                    arr[n_i][n_j]=1;
                }
            }
        }

        return false;

    }
}
