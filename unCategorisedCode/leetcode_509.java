package unCategorisedCode;

public class leetcode_509 {
    public static void main(String[] args){
        System.out.println(fib(7));
    }
    static long[] memo;
    public static long fib(int n){
        if (memo==null){
            memo = new long[n+1];
        }
        if (n<=1){
            return n;
        }
        if (memo[n]!=0){
            return memo[n];
        }
        memo[n] = fib(n-1)+fib(n-2);
        return memo[n];
    }
}
