package Graph;

public class gfg_floyd_warshall_algo {

    class Solution {
        public void floydWarshall(int[][] dist) {
            fWS(dist);
        }

        void fWS(int[][]adjMat){
            int n = adjMat.length;

            for(int k = 0;k<n;k++){
                for(int i = 0;i<n;i++){
                    for(int j = 0;j<n;j++){
                        if(adjMat[i][k] != 100000000 && adjMat[k][j] != 100000000) {
                            adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                        }
                    }
                }
            }


        }
    }
}
