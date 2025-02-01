public class leetcode_279 {

    static int[] memo;
    public static void main(String[] args) {
        int n = 12;
        memo = new int[n + 1];
        System.out.println(minCount(n));

    }

    public static int minCount(int n){
        if (n==0) {
            return 0;
        }
        if (memo[n] != 0){
            return memo[n];
        }
        int minCount = Integer.MAX_VALUE;
        for (int i =1;i*i<=n;i++){
          int res = 1+minCount(n-i*i);
          minCount = Math.min(minCount, res);
        }
        return memo[n] = minCount;
    }
}
