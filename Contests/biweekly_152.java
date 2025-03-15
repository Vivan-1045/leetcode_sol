package Contests;

import java.util.HashSet;
import java.util.Set;

public class biweekly_152 {
    public static void main(String[] args) {
        int []arr = {0,6,6};
        System.out.println(digitFormed(arr));
    }
    public static int digitFormed(int [] arr){
        int n = arr.length;

        Set<Integer> uniqueNumbers = new HashSet<>();

        int evenCount = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }
        if (evenCount == 0) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;

            for (int j = 0; j < arr.length; j++) {
                if (i == j) continue;

                for (int k = 0; k < arr.length; k++) {
                    if (i == k || j == k) continue;

                    if (arr[k] % 2 != 0) continue;

                    uniqueNumbers.add(arr[i] * 100 + arr[j] * 10 + arr[k]);
                }
            }
        }

        return uniqueNumbers.size();
    }
}
