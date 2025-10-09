package Greedy;

import java.util.Arrays;

public class leetcode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        return totalOverlapInt(intervals);
    }

    int totalOverlapInt(int[][] intV){
        Arrays.sort(intV,(a, b)->Integer.compare(a[1],b[1]));

        int initE = intV[0][1];
        int cnt = 0;
        for(int i = 1;i<intV.length;i++){
            int s = intV[i][0],e=intV[i][1];

            if(initE > s){
                cnt++;
            }
            else if(initE <= s){
                initE = e;
            }
        }

        return cnt;
    }
}
