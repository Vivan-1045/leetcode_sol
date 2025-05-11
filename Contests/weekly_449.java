package Contests;

import java.util.*;

public class weekly_449 {
    public static void main(String[] args) {
        int [][] grid = {{4,1,8},{3,2,6}};
        System.out.println(equalSumGrid(grid));
    }

    //question 1
    public static int noOfDistinct(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int distinct = freq.size();
        if (distinct <= k) return 0;

        List<Integer> freqList = new ArrayList<>(freq.values());
        Collections.sort(freqList);

        int deletions = 0;
        int removeCount = distinct - k;

        for (int i = 0; i < removeCount; i++) {
            deletions += freqList.get(i);
        }

        return deletions;
    }

    //question 2
//    public static boolean equalSumGrid(int[][]grid){
//        int totalSum = getTotalSum(grid);
//
//        //for Horizontal cut
//        int rowSum =0,colSum =0;
//        for (int i =0;i<grid.length-1;i++){
//            rowSum += getSum(grid[i]);
//            if (rowSum == (totalSum-rowSum)){
//                return true;
//            }
//        }
//
//        //for Vertical cut
//        for (int j = 0; j < grid[0].length - 1; j++) {
//            for (int i = 0; i < grid.length; i++) {
//                colSum += grid[i][j];
//            }
//            if (colSum == (totalSum-colSum)){
//                return true;
//            }
//        }
//        return false;
//
//
//    }
//    public static int getTotalSum(int[][] arr){
//        int ans = 0;
//        for (int[] arr1: arr){
//            for (int ele : arr1){
//                ans += ele;
//            }
//        }
//        return ans;
//    }
//
//    public static int getSum(int []arr){
//        int sum = 0;
//        for (int i : arr){
//            sum += i;
//        }
//        return sum;
//    }


    //question 3 gives wrong answer [[1,2,4],[2,3,5]]
    public static boolean equalSumGrid(int[][] grid) {
        int totalSum = getTotalSum(grid);
        int m = grid.length, n = grid[0].length;

        int topSum = 0;
        for (int i = 0; i < m - 1; i++) {
            topSum += getSum(grid[i]);
            int bottomSum = totalSum - topSum;

            if (topSum == bottomSum) return true;

            if (Math.abs(topSum - bottomSum) <= getMaxRemovable(grid, i + 1, 0, m - 1, n - 1)) {
                return true;
            }
        }

        int[] colSums = new int[n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSums[j] += grid[i][j];
            }
        }

        int leftSum = 0;
        for (int j = 0; j < n - 1; j++) {
            leftSum += colSums[j];
            int rightSum = totalSum - leftSum;

            if (leftSum == rightSum) return true;

            if (Math.abs(leftSum - rightSum) <= getMaxRemovable(grid, 0, j + 1, m - 1, n - 1)) {
                return true;
            }
        }

        return false;
    }

    public static int getTotalSum(int[][] arr) {
        int ans = 0;
        for (int[] arr1 : arr) {
            for (int ele : arr1) {
                ans += ele;
            }
        }
        return ans;
    }

    public static int getSum(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    public static int getMaxRemovable(int[][] grid, int rowStart, int colStart, int rowEnd, int colEnd) {
        int maxRemovable = 0;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = colStart; j <= colEnd; j++) {
                maxRemovable = Math.max(maxRemovable, grid[i][j]);
            }
        }
        return maxRemovable;
    }

}
