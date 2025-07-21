package Stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_503 {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterEle(arr)));
    }
    public static int[] nextGreaterEle(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();

        for(int i = 0;i<n;i++){
            for(int j = i+1;j<2*n;j++){
                if (arr[i]<arr[j%n]){
                    st.add(arr[j%n]);
                    break;
                }
                if (i==j%n){
                    st.add(-1);
                    break;
                }
            }

        }

        int[] ans = new int[st.size()];
        int i = st.size()-1;
        while (!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }

        return ans;
    }
}
