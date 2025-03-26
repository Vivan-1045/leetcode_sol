package Matrix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class leetcode_2033 {
    public static void main(String[] args) {
        int x = 84;
        int[][]grid = {{980,476,644,56},{644,140,812,308},{812,812,896,560},{728,476,56,812}};
        System.out.println(minOpr(grid,x));
    }
    public static int minOpr(int [][] grid,int x){
        ArrayList<Integer> list = new ArrayList<>();
        for(int [] row:grid){
            for (int j : row) {
                list.add(j);
            }
        }

        Collections.sort(list);
        int s =0,e=list.size();
        int m = s+(e-s)/2;

        int ans = 0;

        for (Integer integer : list) {
            if (Math.abs(list.get(m) - integer) % x != 0) {
                return -1;
            }
            ans += Math.abs(list.get(m) - integer) / x;
        }
        return ans;
    }
}
