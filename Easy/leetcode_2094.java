package Easy;

import java.util.*;

public class leetcode_2094 {
    public static void main(String[] args) {
        int [] arr= {1,1,3,5,9};
        System.out.println(Arrays.toString(threeDigitArray(arr)));
    }
    public static int[] threeDigitArray(int[] arr){
        Set<Integer> st = new HashSet<>();
        int n = arr.length;
        for (int i = 0;i<n;i++){
            if (arr[i]==0){
                continue;
            }
            for (int j = 0;j<n;j++){
                if (i==j){
                    continue;
                }
                for (int k =0;k<n;k++){
                    if (j==k || i==k){
                        continue;
                    }
                    if (arr[k]%2!=0){
                        continue;
                    }
                    st.add(100*arr[i]+10*arr[j]+arr[k]);
                }
            }
        }

        int[] arr1 = new int[st.size()];
        int j = 0;
        for (int i :st){
            arr1[j] =i;
            j++;
        }
        Arrays.sort(arr1);
        return arr1;
    }
}
