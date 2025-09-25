package Matrix;

import java.util.List;

public class leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minTotal(triangle);
    }

    int minTotal(List<List<Integer>> tri){
        for(int i= tri.size()-1;i>=1;i--){
            int k = i-1;

            for(int j = i-1;j>=0;j--){
                int min = Math.min(tri.get(i).get(j),tri.get(i).get(j+1));
                tri.get(k).set(j,tri.get(k).get(j)+min);
            }
        }

        return tri.get(0).get(0);
    }
}
