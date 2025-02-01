import java.util.Arrays;

public class leetcode_1356 {
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(CountArray(arr)));
    }
    public static int[] CountArray(int[]n){
        int l = n.length;
        int count[] = new int[l];
        for (int i = 0;i<l-1;i++){
            int count1 = 0;
            int m = n[i];
            while (m>0){
                if ((m&1)==1){
                    count1++;
                }
                m = m>>1;
            }
            count[i] = count1;
        }

        return count;
    }
}
