package Contests;

import java.util.*;

public class weekly_455 {
    public static void main(String[] args) {
//        int [] arr= {0,1,0,2,0,3,0,4,0,5};
//        System.out.println(recoverLostCoin(arr));
        String s = "abcdefghi";
        System.out.println(Arrays.toString(partitionedString(s, 3, 'x')));
    }
    public static boolean isprimeFrequency(int [] arr){
        Map<Integer,Integer> mp = new HashMap<>();
        for (int i = 0;i<arr.length;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            if (isPrime(entry.getValue())){
                return true;
            }
        }
        return false;
    }
    public static boolean isPrime(int n){
        if (n<=1){
            return false;
        }
        if (n==2){
            return true;
        }
        if (n%2==0){
            return false;
        }
        for (int i = 3;i*i<=n;i+=2){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> recoverLostCoin(int[] arr) {
        int n = arr.length;
        int[] dp = new int[101];
        dp[0] = 1;

        List<Integer> res = new ArrayList<>();

        for (int coin = 1; coin <= n; coin++) {
            int[] copyDp = Arrays.copyOf(dp, n + 1);

            for (int i = coin; i <= n; i++) {
                copyDp[i] += copyDp[i - coin];
            }

            boolean isValid = true;
            boolean needChange = false;

            for (int i = 1; i <= n; i++) {
                if (copyDp[i] > arr[i - 1]) {
                    isValid = false;
                    break;
                }
                if (copyDp[i] > dp[i]) {
                    needChange = true;
                }
            }

            if (isValid && needChange) {
                res.add(coin);
                dp = copyDp;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] != arr[i - 1]) {
                return new ArrayList<>();
            }
        }

        return res;
    }
    public static String []partitionedString(String s, int k, char x){
        while(s.length()%k != 0){
            s = s + String.valueOf(x);
        }
        String [] ans = new String[s.length()/k];
        int j = 0;
        for(int i = 0;i<s.length();i+=k){
            ans[j] = s.substring(i,k+i);
            j++;
        }
        return ans;
    }
}
