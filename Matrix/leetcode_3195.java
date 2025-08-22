package Matrix;

public class leetcode_3195 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0},{0,0,0}};
        System.out.println(minArea(grid));
    }

    public static int minArea(int[][]grid){
        int r = grid.length;
        int c = grid[0].length;
        int Ri=-1,Rf=-1,Ci=-1,Cf=-1;
        boolean initRow =  false;
        boolean finalRow =  false;
        boolean initCol =  false;
        boolean finalCol =  false;
        //Rows coordinate
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(grid[i][j]==1){
                    Ri=i;
                    initRow = true;
                    break;
                }
            }
            if (initRow){
                break;
            }

        }


        for(int i = r-1;i>=0;i--){
            for(int j = 0;j<c;j++){
                if(grid[i][j]==1){
                    Rf=i;
                    finalRow = true;
                    break;
                }
            }
            if (finalRow) {
                break;
            }
        }

        //Columns coordinate
        for(int j = 0;j<c;j++){
            for(int i = 0;i<r;i++){
                if(grid[i][j]==1){
                    Ci = j;
                    initCol = true;
                    break;
                }
            }
            if (initCol) {
                break;
            }
        }

        for(int j = c-1;j>=0;j--){
            for(int i = 0;i<r;i++){
                if(grid[i][j]==1){
                    Cf = j;
                    finalCol = true;
                    break;
                }
            }
            if (finalCol) {
                break;
            }
        }

        if(Rf==-1 && Ri==-1 && Cf==-1&&Ci==-1){
            return 0;
        }
        return (Rf-Ri+1)*(Cf-Ci+1);
    }
}
