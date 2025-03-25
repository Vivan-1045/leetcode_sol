package Array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class leetcode_3394 {
    public static void main(String[] args) {
        int n = 4;
        int [][] rect = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        System.out.println(isPossible(n,rect));
    }
    public static boolean isPossible(int n , int [][] rect){
        List<List<Integer>> xAxis = new ArrayList<>();
        List<List<Integer>> yAxis = new ArrayList<>();

        for (int [] rec : rect){
            int x1 = rec[0];
            int x2 = rec[2];
            int y1 = rec[1];
            int y2 = rec[3];
            List<Integer> temp = new ArrayList<>();
            temp.add(x1);
            temp.add(x2);
            xAxis.add(temp);
            temp = new ArrayList<>();
            temp.add(y1);
            temp.add(y2);
            yAxis.add(temp);
        }

        if (mergeInterval(xAxis)){
            return true;
        }else{
            return mergeInterval(yAxis);
        }

    }

    public static boolean mergeInterval(List<List<Integer>> Axis){
        Axis.sort(Comparator.comparingInt(a->a.get(0)));
        int start = (Axis.get(0)).get(0);
        int end = (Axis.get(0)).get(1);

        ArrayList<int[]> res = new ArrayList<>();


        for (int i = 1;i<Axis.size();i++){
            int s= (Axis.get(i)).get(0);
            int e = (Axis.get(i)).get(1);

            if (end>s){
                end = Math.max(end,e);
            }else{
                res.add(new int[]{start, start});  // Add the merged interval
                end = e;
                start = s;
            }
        }
        res.add(new int[]{start,end});

        return res.size()>=3;

    }

}

