package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class leetcode_56 {
    public static void main(String[] args) {
        int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(mergedInterval(arr)));
    }
    public static int[][] mergedInterval(int[][] intervals){
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1;i<n;i++){

            int s = intervals[i][0];
            int e = intervals[i][1];

            //if the arrays interval are overlapped
            if (end>= s){
                end = Math.max(end,e);
            }else{
                res.add(new int[]{start,end});
                end=e;
                start = s;
            }

        }
        res.add(new int[]{start,end});
        return res.toArray(new int[res.size()][]);
    }
}
