import java.util.ArrayList;
import java.util.List;

public class leetcode_39 {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 8;
        System.out.println(combinationSum(arr, target));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backTrack(candidates,target,0, current , res);
        return res;
    }
    public static void backTrack(int[]candidates,int target,int s,List<Integer> current , List<List<Integer>> res ){
        //Base condition
        if (target==0){
            res.add(new ArrayList<>(current));
        }

        //check for all element of candidates
        for (int i = s;i<candidates.length;i++){
            if (candidates[i]>target) continue;
            //Make changes
            current.add(candidates[i]);
            //Explore
            backTrack(candidates, target-candidates[i],i,current,res);
            //Revert all changes
            current.remove(current.size()-1);
        }
    }
}
