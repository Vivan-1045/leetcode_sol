package Hard;

public class leetcode_3640 {
    Long dp[][] = new Long[100001][4];
    public long maxSumTrionic(int[] nums) {
        return solve(nums,0,0);
    }

    long solve(int[]arr, int idx, int tnd){
        int n = arr.length;
        if(dp[idx][tnd] != null){
            return dp[idx][tnd];
        }

        if(idx==n){
            if(tnd==3){
                return dp[idx][tnd]=0L;
            }else{
                return dp[idx][tnd]=Long.MIN_VALUE/2;
            }
        }

        long add = Long.MIN_VALUE/2;
        long skip = Long.MIN_VALUE/2;

        if(tnd==0){
            skip = solve(arr,idx+1,tnd);
        }
        if(tnd == 3){
            add = arr[idx];
        }

        if(idx+1<n){
            int curr = arr[idx];
            int next = arr[idx+1];

            if(tnd==0 && curr<next){
                add = Math.max(add,curr+solve(arr,idx+1,tnd+1));
            }else if(tnd==1){
                if(curr<next){
                    add = Math.max(add,curr+solve(arr,idx+1,tnd));
                }else if(curr>next){
                    add = Math.max(add,curr+solve(arr,idx+1,tnd+1));
                }
            }else if(tnd==2){
                if(curr>next){
                    add = Math.max(add,curr+solve(arr,idx+1,tnd));
                }else if(curr<next){
                    add = Math.max(add,curr+solve(arr,idx+1,tnd+1));
                }
            }else if(tnd==3 && curr<next){
                add = Math.max(add,curr+solve(arr,idx+1,tnd));
            }
        }

        return dp[idx][tnd]=Math.max(add,skip);
    }
}
