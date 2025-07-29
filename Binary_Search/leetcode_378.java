package Binary_Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class leetcode_378 {
    public static void main(String[] args) {
       int[][]arr = {{1,2},{3,3}};
        System.out.println(kthSmall(arr,2));
    }
    public static int kthSmall(int[][] mat,int k){
        if(mat.length==1 && k ==1){
            return mat[0][0];
        }
        List<Integer> list =new ArrayList<>();
        for(int i = 0;i<mat.length;i++){
            for (int[] ints : mat) {
                list.add(ints[i]);
            }
        }

        Collections.sort(list);
        return list.get(k-1);
    }
}
