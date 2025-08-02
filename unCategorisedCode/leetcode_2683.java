package unCategorisedCode;

public class leetcode_2683 {
    public static void main(String[] args) {
        int [] A = {1,0,1,0};
        System.out.println(isBinary(A));
    }
    public static boolean isBinary(int[] num){
        int n = num.length;
        int [] orig = new int[n];
        orig[0]=0;
        for (int i =0;i<n-1;i++){
            orig[i+1] = num[i]^orig[i];
        }
        if ((orig[n-1]^orig[0])==num[n-1]){
            return true;
        }
        orig[0]=1;
        for (int i = 0; i < n - 1; i++) {
            orig[i+1] = orig[i]^num[i];
        }
        if ((orig[n-1]^orig[0])==num[n-1]){
            return true;
        }
        return false;
    }

    // Another approach
    public static boolean isValidBinary(int[] num){
        int res = 0;
        for (int j : num) {
            res ^= j;
        }
        return res == 0;
    }
}
