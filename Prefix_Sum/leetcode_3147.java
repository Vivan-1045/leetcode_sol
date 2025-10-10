package Prefix_Sum;

public class leetcode_3147 {
    public int maximumEnergy(int[] energy, int k) {
        return maxEnergy(energy,k);
    }

    int maxEnergy(int[]arr, int k){
        int n = arr.length;
        int[] copyArr = new int[n];

        for(int i = 0;i<n;i++){
            copyArr[i] = arr[i];
        }

        for(int i = n-1-k;i>=0;i--){
            if(i+k<n){
                copyArr[i] += copyArr[i+k];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int ele : copyArr){
            max = Math.max(ele,max);
        }

        return max;
    }
}
