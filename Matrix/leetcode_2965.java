package Matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_2965 {
    public static void main(String[] args) {
        int [][] grid = {{9,1,7},{8,9,2},{3,4,6}};
        System.out.println(Arrays.toString(getmissingRepeated(grid)));
    }
    public static int[] getmissingRepeated(int[][] grid){
        int n = grid.length;
        int a = -1;
        int b = -1;

        Map<Integer,Integer> mp = new HashMap<>();
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                mp.put(ints[j], mp.getOrDefault(ints[j], 0) + 1);
            }
        }

        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            System.out.println("key : "+ entry.getKey()+" Value : "+ entry.getValue());
        }

        for (int i = 1; i<=n*n;i++){
            if (!mp.containsKey(i)){
                a = i;
            } else if (mp.get(i)==2) {
                b = i;
            }
        }
        return new int[]{b,a};
    }
}
