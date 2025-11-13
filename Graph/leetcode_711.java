package Graph;// User function Template for Java

import java.util.*;

class leetcode_711 {

    static class Pair{
        int a;
        int b;

        Pair(int x,int y){
            this.a=x;
            this.b=y;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
        {0, 0, 0, 1, 1},
    {0, 0, 0, 1, 1}};
        System.out.println(Solve(arr));
    }
    static int Solve(int[][]arr){
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] vis = new boolean[n+1][m+1];
        Set<List<String>> ls = new HashSet<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] ==1 && !vis[i][j]){
                    List<String> curr = bfs(i,j,arr,vis);
                    ls.add(curr);
                }
            }
        }

        return ls.size();
    }

    static int[]delRow = {0,1,0,-1};
    static int[]delCol = {1,0,-1,0};

    static List<String> bfs(int r, int c, int[][] arr, boolean[][] vis){

        List<String> curr = new ArrayList<>();

        Queue<Pair> qu = new LinkedList<>();
        vis[r][c] = true;
        qu.add(new Pair(r,c));

        while(!qu.isEmpty()){
            int i = qu.peek().a;
            int j = qu.peek().b;
            curr.add((i-r) +","+ (j-c));
            qu.remove();

            for(int k = 0;k<4;k++){
                int nR = i + delRow[k];
                int nC = j + delCol[k];

                if(nR>=0 &&nC>=0 && nR<arr.length && nC<arr[0].length && !vis[nR][nC] && arr[nR][nC]==1){
                    vis[nR][nC] = true;
                    qu.add(new Pair(nR,nC));
                }
            }
        }

        return curr;
    }


}
