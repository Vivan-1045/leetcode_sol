package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_118 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new List[]{solvePattern(5)}));
    }
    public static List<List<Integer>> solvePattern(int n){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));

        for(int i =1;i<n;i++){
            List<Integer> curr = ans.get(ans.size()-1);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);

            for(int j = 1;j<=curr.size()-1;j++){
                newList.add(curr.get(j)+curr.get(j-1));
            }
            newList.add(1);
            ans.add(newList);
        }

        return ans;
    }
}
