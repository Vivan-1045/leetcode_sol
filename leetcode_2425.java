import java.util.HashMap;
import java.util.Map;

public class leetcode_2425 {
    public static void main(String[] args) {
        int []A = {2};
        int []B = {5};
        System.out.println(xor(A, B));

    }
    public static int xor(int[] num1, int[] num2){

        int n = num1.length;
        int m = num2.length;
        int res =0;
        if (n>1&&(n==m && n%2 != 0)){
            return 0;
        }
        if (n%2 != 0 && m%2 ==0){
            for (int num: num2){
                res ^= num;
            }
        } else if (n%2 == 0 && m%2 !=0) {
            for (int num: num1){
                res ^= num;
            }
        }
        if (n%2!=0&&m%2!=0){
            for (int num: num1){
                res^= num;
            }
            for (int num : num2){
                res^=num;
            }
        }
       return res;
    }
}
