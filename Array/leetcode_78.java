package Array;

import java.util.ArrayList;
import java.util.List;

public class leetcode_78 {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        System.out.println(AllSubsets(arr));
    }
    public static List<List<Integer>> AllSubsets(int[] arr){
        //create outer list with minimum one empty internal list
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num: arr){
            int n = outer.size();
            for (int i =0;i<n;i++){
                //get the copy of internal list from outer list and that internal updated list in the outer list
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

}
