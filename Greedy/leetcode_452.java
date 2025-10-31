package Greedy;

import java.util.Arrays;

public class leetcode_452 {
    public int findMinArrowShots(int[][] points) {
        return minArrow(points);
    }

    int minArrow(int[][] arr){

        Arrays.sort(arr , (a, b) -> Integer.compare(a[1],b[1]));
        int cnt = 1;
        int s = arr[0][1];


        for(int i = 1;i<arr.length;i++){
            int a = arr[i][0];
            int b = arr[i][1];

            if(a<=s){
                continue;
            }else{
                cnt++;
                s = b;
            }
        }


        return cnt;
    }
}
