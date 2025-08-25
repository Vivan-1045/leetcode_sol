package Matrix;

import java.util.*;

public class leetcode_498 {
    public static void main(String[] args) {

    }
    public static int[] digonalOrder(int[][]mat){
        TreeMap<Integer, List<Integer>> mp = new TreeMap<>();
        mp.put(0,new ArrayList<>());
        int n = mat.length;
        int m = mat[0].length;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mp.containsKey(i+j)){
                    mp.get(i+j).add(mat[i][j]);
                }else{
                    mp.put(i+j,new ArrayList<>(Arrays.asList(mat[i][j])));
                }
            }
        }

        int[] res = new int[n*m];
        int i = 0;
        int k = 0;
        for(List<Integer> list : mp.values()){
            if(k==0 || k== 1 || k%2!=0){
                for(int ele : list){
                    res[i] = ele;
                    i++;
                }
            }else{
                Collections.reverse(list);
                for(int ele : list){
                    res[i] = ele;
                    i++;
                }
            }
            k++;
        }

        return res;
    }
}
