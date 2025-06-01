package Stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_735 {
    public static void main(String[] args) {
       int[] arr = {5,-5};
        System.out.println(Arrays.toString(asteroidAfterCollision(arr)));
    }
    public static int[] asteroidAfterCollision(int[] arr){
        Stack<Integer> st = new Stack<>();
        for (int num : arr){
              while (!st.isEmpty() && st.peek()>0 && num<0) {
                  int sum = st.peek() + num;
                  if (sum == 0) {
                      st.pop();
                      num = 0;
                  }
                  if (sum < 0) {
                      st.pop();
                  }
                  if(sum>0){
                      num = 0;
                  }
              }
              if (num!=0) {
                  st.push(num);
              }
        }
        int [] ans = new int[st.size()];
        int i = st.size()-1;
        while (!st.isEmpty()){
            ans[i] = st.pop();
            i--;
        }
        return ans;
    }
}
