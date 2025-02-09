import java.util.HashMap;
import java.util.Map;

public class leetcode_2364 {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        System.out.println(BadPairCount(arr));
    }

    // Gives TLE 59/65
    public static long badCount(int[] arr){
        int n = arr.length;
        long count = 0;
        for (int i = 0; i<n;i++){
            for (int j = i+1; j<n;j++){
                if (arr[i]-i == arr[j]-j){
                    count += 1;
                }
            }
        }
        return ((long) n *(n-1))/2 - count;
    }


    //Optimal Approach
    public static long BadPairCount(int [] arr){
        int n = arr.length;
        long count = 0;
        // Create map to store the frequency of pair (arr[i]-i)
        // Since for goodPair frequency will be more than or equal to 2
        Map<Integer,Integer> mp= new HashMap<>();
        for(int i = 0;i<n;i++){
            mp.put(arr[i]-i, mp.getOrDefault(arr[i]-i,0)+1);
        }

        // Total number of pairs will be calculated as : n*(n-1)/2
        //totalBadPairs = totalPairs - goodPairCount

        long goodPairCount = 0;
        for (Map.Entry<Integer,Integer> entry : mp.entrySet()){
           int freq = entry.getValue();
           if (freq>=2){
               // if frequency is greater or equal to 2 then the goodPair will be frequency*(frequency-1)/2
               goodPairCount += (long)freq*(freq-1)/2;
           }
        }
        return (long) n*(n-1)/2 - goodPairCount;
    }
}
