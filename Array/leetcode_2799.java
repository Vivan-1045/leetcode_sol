package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode_2799 {
    public static void main(String[] args) {
        int []arr = {1,3,1,2,2};
        System.out.println(countCompleteSubArray(arr));
    }
    public static int countCompleteSubArray(int [] arr){
        int n = arr.length;
        Set<Integer> st = new HashSet<>();
        for (int ele: arr){
            st.add(ele);
        }

        int totalUnique = st.size();
        int res = 0;
        int i = 0;

        Map<Integer,Integer> mp = new HashMap<>();
        for (int j = 0;j<n;j++){
            mp.put(arr[j],mp.getOrDefault(arr[j],0)+1);

            while (mp.size()==totalUnique){
                res += n-j;

                mp.put(arr[i],mp.get(arr[i])-1);
                if (mp.get(arr[i])==0){
                    mp.remove(arr[i]);
                }
                i++;
            }
        }
        return res;
    }
}
