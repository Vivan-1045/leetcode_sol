package Contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class weekly_475 {

    //Question 01
    public int minimumDistance(int[] nums) {
        return minDist(nums);
    }
    int minDist(int[] arr){
        int min= Integer.MAX_VALUE;

        for(int i = 0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                for(int k = j+1;k<arr.length;k++){
                    if(arr[i]==arr[j] && arr[j]==arr[k]){
                        min = Math.min(min,Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i));
                    }
                }
            }
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    //Question 02 (Optimised version of first)
    public int minimumDistance1(int[] nums) {
        return minDist(nums);
    }

    int minDist1(int[] arr){
        Map<Integer, List<Integer>> mp = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            mp.computeIfAbsent(arr[i],k -> new ArrayList()).add(i);
        }

        int min = Integer.MAX_VALUE;

        for(List<Integer> ls : mp.values()){
            int n = ls.size();

            if(n<3){
                continue;
            }

            for(int i = 0;i+2<n;i++){
                int d = 2*(ls.get(i+2)-ls.get(i));

                if(d<min){
                    min = d;

                    if(min==4){
                        return min;
                    }
                }
            }
        }

        return min==Integer.MAX_VALUE?-1:min;
    }

    //Question 03
    Integer[][][]dp;
    public int maxPathScore(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k+1];
        return maxPath(grid,0,0,k);
    }

    int maxScore = Integer.MIN_VALUE;
    int maxPath(int[][] arr,int i, int j, int k){


        if(i>=arr.length||j>=arr[0].length){
            return -1;
        }

        if(dp[i][j][k] != null){
            return dp[i][j][k];
        }

        int cost = arr[i][j]==0?0:1;
        int score = arr[i][j]==0?0:arr[i][j];

        if(k-cost<0){
            return -1;
        }

        if(i==arr.length-1 && j == arr[0].length-1){
            return score;
        }



        int r = maxPath(arr,i,j+1,k-cost);
        int d = maxPath(arr,i+1,j,k-cost);

        int total = Math.max(r,d);

        dp[i][j][k] = total==-1?-1:total+score;

        return dp[i][j][k];
    }
}
