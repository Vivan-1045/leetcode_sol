package Matrix;

import java.util.ArrayList;
import java.util.List;

public class leetcode_54 {

    public static void main(String[] args) {
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralTraverse(arr));
    }

    public static List<Integer> spiralTraverse(int[][]mat){
        List<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;

        boolean [][]visit = new boolean[m][n];

        int total = m*n;
        int count = 0;
        int left = 0,down = m-1,right = n-1,up = 0;
       while (count<total){

           // Moving towards right
            for (int i = left;i<=right && count<total; i++){
                if (!visit[up][i]){
                    ans.add(mat[up][i]);
                    visit[up][i] = true;
                    count++;

                }

            }
            up++;

           // Moving towards down
            for(int i = up;i<=down && count<total; i++){
                if (!visit[i][right]){
                    ans.add(mat[i][right]);
                    visit[i][right] = true;
                    count++;
                }
            }

            right--;

           // Moving towards left
            for(int i = right ; i>= left && count<total ;i--){
                if (!visit[down][i]){
                    ans.add(mat[down][i]);
                    visit[down][i] = true;
                    count++;

                }
            }

            down--;

            // Moving towards up
            for(int i = down ; i>=up && count < total ;i--){
                if (!visit[i][left]){
                    ans.add(mat[i][left]);
                    visit[i][left] = true;
                    count++;

                }
            }

            left++;
        }


        return ans;
    }
}
