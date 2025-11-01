package Greedy;

import java.util.Arrays;

public class leetcode_646 {
    public int findLongestChain(int[][] pairs) {
        return longestChain(pairs);
    }

    int longestChain(int[][] pair){

        //Sort the array on the basis of 2nd element
        Arrays.sort(pair,(a, b) -> Integer.compare(a[1],b[1]));

        int cnt = 1;

        for(int i = 0;i<pair.length;i++){
            int b = pair[i][1];
            int curr =1;
            for(int j = i+1;j<pair.length;j++){
                int c = pair[j][0];
                int d = pair[j][1];
                if(b<c){
                    curr+=1;
                    b = d;
                }
            }
            cnt = Math.max(cnt,curr);
        }

        return cnt;
    }
}
