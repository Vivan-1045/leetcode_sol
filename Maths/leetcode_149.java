package Maths;

import java.util.HashMap;
import java.util.Map;

public class leetcode_149 {
    public static void main(String[] args) {
        int[][] arr = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(maxPoint(arr));
    }
    public static int maxPointOnLine(int[][] arr){
        int n = arr.length;
        if(n==1||n==2){
            return n;
        }
        int res = 0;
        for (int i = 0; i<n;i++){
            for (int j = i+1;j<n;j++){
                int count  = 2;
                int y2 = arr[j][1];
                int y1 = arr[i][1];
                int x1 = arr[i][0];
                int x2 = arr[j][0];

                for (int k = 0;k<n;k++){
                    if (k!=i&&k!=j){
                        int x_ = arr[i][0];
                        int y_ = arr[i][1];
                        int x3 = arr[k][0];
                        int y3 = arr[k][1];
                        if ((y2-y1)*(x3-x_)==(y3-y_)*(x2-x1)){
                            count += 1;
                        }
                    }
                }
                res = Math.max(res,count);
            }
        }
        return res;
    }

    public static int maxPoint(int[][] arr){
        int n = arr.length;
        if(n==1||n==2){
            return n;
        }
        int res = 0;
        for (int i = 0;i<n;i++){
            Map<String,Integer> mp = new HashMap<>();
            int count = 0;
            for (int j = i+1;j<n;j++){
                int dx = arr[j][0]-arr[i][0];
                int dy = arr[j][1]-arr[i][1];
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String slope = dx + "/" + dy;
                mp.put(slope, mp.getOrDefault(slope, 0) + 1);
                count = Math.max(count, mp.get(slope));
            }
            res = Math.max(res,count+1);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
