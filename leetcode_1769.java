import java.util.Arrays;

public class leetcode_1769 {
    public static void main(String[] args) {
        String s = "001011";
        System.out.println(Arrays.toString(optimalWay(s)));
    }

    //Memory Efficient way
    public static int[] ansArray(String s){
        int ans[] = new int[s.length()];
        for (int i =0;i<s.length();i++){
            int sum = 0;
            for (int j = s.length()-1;j>=0;j--){
//                if (s.charAt(j)=='1'){
//                    sum += Math.abs(i-j);
//                }
                //Alternate
                sum += s.charAt(j)=='1'?Math.abs(i-j):0;
            }
            ans[i] = sum;
        }
        return ans;
    }

    //Time efficient way
    public static int[] optimalWay(String s){
        int left = 0;
        int left_sum = 0;
        int ans[] = new int[s.length()];

        //Commulative sum of left side balls
        for (int i =0;i<s.length();i++){
            ans[i] = left_sum;
            left += s.charAt(i)=='1'?1:0;
            left_sum += left;
        }
        left = 0;
        left_sum = 0;

        //Commulative sum of right side balls
        for (int i =s.length()-1;i>=0;i--){
            ans[i] += left_sum;
            left += s.charAt(i)=='1'?1:0;
            left_sum += left;
        }
        return ans;
    }
}
