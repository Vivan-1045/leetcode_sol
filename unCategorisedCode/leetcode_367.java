package unCategorisedCode;

public class leetcode_367 {
    public static void main(String[] args) {
        int n = 808201;
        System.out.println(IsperfectSqrt(n));
    }

    public static boolean IsperfectSqrt(int n) {
        double x = n;
        while (x * x > n) {
            //Newton's rapson method
            double root = (x + (n / x)) / 2;
            if (Math.abs(root - x) < 0.5) {
                break;
            }
            x = root;
        }
        int rootInt = (int) x;
        return rootInt * rootInt == n;
    }
}

