package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_542 {
    class Pair{
        int a,b,c;
        Pair(int _a,int _b, int _c){
            a=_a;
            b=_b;
            c=_c;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        return nearestDist(mat);
    }

    int [][]nearestDist(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] res = new int[n][m];

        Queue<Pair> qe = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j]==0){
                    qe.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }else{
                    vis[i][j] = 0;
                }
            }
        }

        int[] delr = {-1,0,+1,0};
        int[] delc = {0,+1,0,-1};

        while(!qe.isEmpty()){
            int r = qe.peek().a;
            int c = qe.peek().b;
            int step = qe.peek().c;
            qe.remove();
            res[r][c] = step;

            for(int i = 0;i<4;i++){
                int nr = r + delr[i];
                int nc = c + delc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc] == 0){
                    qe.add(new Pair(nr,nc,step+1));
                    vis[nr][nc] = 1;
                }
            }
        }

        return res;
    }
}
