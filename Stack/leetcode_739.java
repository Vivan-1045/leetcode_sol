package Stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_739 {
    public static void main(String[] args) {
        int[] arr={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(getWormthDay(arr)));
    }
    public static int[] getWormthDay(int[] arr){
            int n = arr.length;
            int [] ans = new int[n];
            Stack<Integer> st = new Stack<>();
            for(int i = 0;i<n;i++){
                while(!st.isEmpty() && arr[i]>arr[st.peek()]){
                    int idx = st.pop();
                    ans[idx] = i-idx;
                }
                st.push(i);
            }
            return ans;
    }
}
