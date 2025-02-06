import java.util.*;

public class leetcode_1726 {
    public static void main(String[] args) {
      int [] arr = {2,3,4,6,8,12};
      System.out.println(tupleCount(arr));
      System.out.println(tupleBrute(arr));

    }

    public static int tupleBrute(int[] arr){
        Arrays.sort(arr);
        int tuple = 0;
        for (int i =0;i<arr.length;i++){
            for (int j = arr.length-1;j>i;j--){
                int product = arr[i]*arr[j];
                Set<Integer> st = new HashSet<>();
                for (int k = i+1;k<j;k++){
                    if (product%arr[k]==0){
                        int dval = product / arr[k];
                        if (st.contains(dval)){
                           tuple += 1;
                        }
                        st.add(arr[k]);
                    }
                }
            }
        }
        return tuple*8;
    }

    public static int tupleCount(int[] arr){
        if (arr.length<4){
            return 0;
        }
        Map<Integer,Integer> mp = new HashMap<>();
        int tuple = 0;

        for (int i =0;i<arr.length-1;i++){
            for (int j = i+1;j<arr.length;j++){
                int CurrentFreq = mp.getOrDefault(arr[i]*arr[j],0);
                mp.put(arr[i]*arr[j],CurrentFreq+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){

           if (entry.getValue()>=2){
               tuple += (entry.getValue()*(entry.getValue()-1)/2);
           }
        }

        return tuple*8;
    }
}
