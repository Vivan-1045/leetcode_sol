public class leetcode_509 {
    public static void main(String[] args){
        System.out.println(fib(7));
    }
    public static int fib(int n){
        if (n<=1){
            return n;
        }
        else {
            return fib(n-1)+fib(n-2);
        }
    }
}
