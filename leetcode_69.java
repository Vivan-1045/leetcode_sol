public class leetcode_69 {
    public static void main(String[] args) {
        System.out.println(Sqrt(5));
    }
    public static int Sqrt(int n) {
        if(n==1){
            return 1;
        }
        double x = n;
        double root = 0;
        while (x * x > n) {
            root = (x + (n / x)) * 0.5;
            if (Math.abs(root - x) < 0.5) {
                break;
            }
            x = root;
        }
        return (int) root;
    }
}
