package Contests;

import java.lang.reflect.Array;
import java.util.*;

public class weekly_447 {
    public static void main(String[] args) {
//        int n = 5;
//        int[][] arr = {{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}};
//        System.out.println(buildCount(n,arr));

//        int n1 = 11;
//        int []arr1 = {1,1,2};
//        List<Integer> ans = findSmallpermut(arr1,n1);
//        System.out.println(ans);

        int []arr2 = {-1,-4,-1,4};
        System.out.println(countWithCondition(arr2));
    }
    public static int buildCount(int n, int[][] buildings){
            Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
            Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();

            for (int[] b : buildings) {
                int x = b[0], y = b[1];
                rowMap.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
                colMap.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
            }

            int count = 0;
            for (int[] b : buildings) {
                int x = b[0], y = b[1];

                boolean left = rowMap.get(x).lower(y) != null;

                boolean right = rowMap.get(x).higher(y) != null;

                boolean up = colMap.get(y).lower(x) != null;

                boolean down = colMap.get(y).higher(x) != null;

                if (left && right && up && down) {
                    count++;
                }
            }

            return count;
    }

    public static List<Integer> findSmallpermut(int[] nums, int k) {
        int n = nums.length;
        int[] copyArrary = Arrays.copyOf(nums, n);
        Arrays.sort(copyArrary);

        String[] numStrs = new String[n];
        int[] pow10 = new int[n];
        for (int i = 0; i < n; i++) {
            numStrs[i] = String.valueOf(copyArrary[i]);
            pow10[i] = (int) Math.pow(10, numStrs[i].length());
        }

        boolean[][] visited = new boolean[1 << n][k];
        List<Integer> result = new ArrayList<>();
        dfs(copyArrary, numStrs, pow10, k, 0, 0, new ArrayList<>(), visited, result);
        return result;
    }

    public static boolean dfs(int[] nums, String[] numStrs, int[] pow10, int k,
                               int mask, int mod, List<Integer> path,
                               boolean[][] visited, List<Integer> result) {
        if (mask == (1 << nums.length) - 1) {
            if (mod == 0) {
                result.addAll(path);
                return true;
            }
            return false;
        }

        if (visited[mask][mod]) return false;
        visited[mask][mod] = true;

        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0) {
                if (i > 0 && nums[i] == nums[i - 1] && (mask & (1 << (i - 1))) == 0)
                    continue;

                int nextMod = (mod * pow10[i] + nums[i]) % k;
                path.add(nums[i]);
                if (dfs(nums, numStrs, pow10, k, mask | (1 << i), nextMod, path, visited, result))
                    return true;
                path.remove(path.size() - 1);
            }
        }
        return false;
    }

    public static int countWithCondition(int[] arr){
        int count = 0;
        int n = arr.length;
        for(int i =0;i<n-2;i++){
            for(int j = i+1;j<i+2;j++){
                for(int k = j+1;k<j+2;k++){
                    if(arr[j]%2==0 && (arr[i]+arr[k] == arr[j]/2)){
                        count +=1;
                    }
                }
            }
        }
        return count;
    }
}
