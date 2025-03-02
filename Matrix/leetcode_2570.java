package Matrix;

import java.util.*;

public class leetcode_2570 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2},{2,3},{4,5}};
        int[][] arr2 = {{1,4},{3,2},{4,1}};
        int[][] arr = resultingArray(arr1,arr2);
        System.out.println(Arrays.deepToString(arr));
    }
    public static int[][] resultingArray(int[][] arr1, int[][] arr2) {
        Map<Integer, Integer> mp = new HashMap<>();

        for (int[] arr : arr1) {
            mp.put(arr[0], mp.getOrDefault(arr[0],0)+ arr[1]);
        }

        for (int[] arr : arr2){
            mp.put(arr[0],mp.getOrDefault(arr[0],0)+arr[1]);
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            result.add(new int[]{entry.getKey(),entry.getValue()});
        }

        //Sort the list in ascending order
        result.sort((a,b) -> Integer.compare(a[0],b[0]));

        return result.toArray(new int[result.size()][]);
    }
}
