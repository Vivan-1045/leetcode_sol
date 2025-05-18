package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1931 {
    static List<String> list = new ArrayList<>();
    static int M = (int) (1e9+7);
    static int[][] arr;

    public static void main(String[] args) {
        System.out.println(paintinGrid(5,5));
    }

    public static int paintinGrid(int m,int n){
        list.clear();
        generateColumnState("", '#',m);
        arr = new int[n][list.size()];
        for (int[] row : arr){
            Arrays.fill(row,-1);
        }

        int result = 0;
        for (int i =0;i<list.size();i++){
            result = (result+solve(n-1,i ,m))%M;
        }

        return result;
    }

    public static void generateColumnState(String curr , char prevCh,int rowRemain ){
        if (rowRemain==0){
            list.add(curr);
            return;
        }
        for(char ch : new char[]{'R', 'G', 'B'}){
            if (ch==prevCh){
                continue;
            }
            generateColumnState(curr+ch,ch,rowRemain-1);
        }

    }

    public static int solve(int remainCols , int prevIdx,int m){

        if (remainCols == 0){
            return 1;
        }

        if (arr[remainCols][prevIdx] != -1){
            return arr[remainCols][prevIdx];
        }

        int ways = 0;
        String prevState = list.get(prevIdx);
        for (int i = 0;i<list.size();i++){
            if (i==prevIdx){
                continue;
            }

            String currState = list.get(i);
            boolean valid = true;
            for (int j = 0;j<m;j++){
                if (prevState.charAt(j) == currState.charAt(j)){
                    valid = false;
                    break;
                }
            }
            if (valid){
                ways = (ways+solve(remainCols-1,i,m))%M;
            }
        }
        return arr[remainCols][prevIdx]=ways;
    }
}
