import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_2017 {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1,15},{1,3,3,1}};
        System.out.println(PathRobot2(grid));
    }
    public static long PathRobot2(int[][]grid){
        //total sum of row 1
        long row1Sum = 0;
        for(int num : grid[0]){
            row1Sum += num;
        }
        long row2Sum = 0;
        long minPathByrobot1 = Long.MAX_VALUE;

        for (int i = 0; i < grid[0].length; i++) {
            row1Sum -= grid[0][i];

            //robot 2 choose the best
            long robot2Path = Math.max(row1Sum, row2Sum);

            //robot 1 wants to minimize the path taken by robot 2
            minPathByrobot1 = Math.min(robot2Path,minPathByrobot1);

            //calculate the commulate sum of row 2
            row2Sum += grid[1][i];
        }
        return minPathByrobot1;
    }
}
