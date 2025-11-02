package Matrix;

public class leetcode_2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        return unGuardedCell(m,n,guards,walls);
    }

    int unGuardedCell(int m, int n, int[][]guard,int[][]walls){
        int[][] arr = new int[m][n];

        for(int[]a : guard){
            arr[a[0]][a[1]] = 1;
        }

        for(int[]b: walls){
            arr[b[0]][b[1]] = 2;
        }

        int cnt = 0;
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};

        for(int[]g : guard){
            for(int []d: dir){
                int x = g[0]+d[0];
                int y = g[1]+d[1];

                while(x>=0 && x<m && y>=0 &&y<n && arr[x][y] != 1 && arr[x][y] != 2){
                    if(arr[x][y]==0){
                        arr[x][y] = 3;
                    }
                    x+=d[0];
                    y+=d[1];
                }
            }
        }

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(arr[i][j]==0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
