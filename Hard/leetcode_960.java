package Hard;

import java.util.Arrays;

//LIS variant
public class leetcode_960 {
    public int minDeletionSize(String[] strs) {
        return minLength(strs);
    }
    int minLength(String[] strs){
        int n = strs.length;
        int m = strs[0].length();
        int res = 1;

        int[] dp =  new int[m];
        Arrays.fill(dp,1);

        for(int i = 0;i<m;i++){
            for(int j = 0;j<i;j++){

                boolean del = true;

                for(int k = 0;k<n;k++){
                    if(strs[k].charAt(j)>strs[k].charAt(i)){
                        del = false;
                        break;
                    }
                }

                if(del){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }

            }

            res = Math.max(res,dp[i]);
        }


        return m-res;
    }
}
