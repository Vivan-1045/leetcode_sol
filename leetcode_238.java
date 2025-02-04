import java.util.Arrays;

public class leetcode_238 {
    public static void main(String[] args) {
        int[] arr = {0,1};
        System.out.println(Arrays.toString(prdouctArray(arr)));
    }
    public static int[] prdouctArray(int[] arr){
        boolean isZero = false;
        int [] res = new int[arr.length];
        int zero = 0,zeroCount = 0;
        for (int i =0;i<arr.length;i++){
            if (arr[i] == 0) {
                isZero = true;
                zeroCount++;
                zero = i;
            }
        }
        if (zeroCount>1){
            Arrays.fill(res,0);
            return res;
        }
        int mul = 1;
        if (isZero){
            for (int n: arr) {
                if (n==0){
                    continue;
                }else {
                    mul *= n;
                }
            }
        }else{
            for(int m : arr){
                mul *= m;
            }
        }
        if (isZero){
            Arrays.fill(res,0);
            res[zero] = mul;
        }else {
            for (int i =0;i<arr.length;i++){
                res[i] = mul/arr[i];
            }
        }
        return res;
    }
}
