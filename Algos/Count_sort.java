package Algos;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Count_sort {
    public static void main(String[] args) {
        int[]arr = {2,3,1,2,8,2,6};
        System.out.println(Arrays.toString(countSort(arr)));
        System.out.println(Arrays.toString(countSortUsingMap(arr)));

    }

    //Using Array
    public static int[] countSort(int[] arr){
        int max = 0;
        for (int num: arr){
            max = Math.max(max,num);
        }
        int [] freqArr = new int[max+1];

        for (int j : arr) {
            freqArr[j]++;
        }

        int k = 0;
        for (int i = 0;i<freqArr.length;i++){
                while (freqArr[i] >0){
                    arr[k++] = i;
                    freqArr[i]--;
                }
        }

        return arr;
    }

    //Using Map
    public static int[] countSortUsingMap(int[] arr){
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for (int num : arr){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        int i = 0;
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
            int freq = entry.getValue();
            while (freq>0){
                arr[i++] = entry.getKey();
                freq--;
            }
        }

        return arr;
    }
}
