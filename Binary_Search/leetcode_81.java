package Binary_Search;

public class leetcode_81 {
    public static void main(String[] args) {
        int [] arr = {2,2,2,3,1};
        System.out.println(searchOpr(arr,1));
    }

    public static boolean searchOpr(int [] arr,int k){
        int pivIdx = pivIdx(arr);
        if (pivIdx==-1){
            return isPresent(arr,k,0,arr.length-1);
        }
        if (arr[pivIdx]==k){
            return true;
        }
        if (arr[pivIdx]>k && arr[arr.length-1]>=k){
            return isPresent(arr,k,pivIdx+1,arr.length-1);
        }else {
            return isPresent(arr,k,0,pivIdx);
        }
    }
    public static boolean isPresent(int[]arr,int k,int s,int e){
        while (s<=e){
            int m = s+(e-s)/2;
            if (k<arr[m]){
                e = m-1;
            } else if (k>arr[m]){
                s = m+1;
            }else {
                return true;
            }
        }

        return false;
    }

    public static int pivIdx(int[] nums){
        int s =0;
        int e = nums.length-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if (m < nums.length - 1 && nums[m] > nums[m + 1]) {
                return m;
            }
            if (m > 0 && nums[m] < nums[m - 1]) {
                return m - 1;
            }
            //To skip the duplicate elements
            if(nums[s]==nums[m] && nums[m]==nums[e]){
                if (s<e && nums[s]>nums[s+1])return s;
                if (e>s && nums[e]<nums[e-1])return e-1;
                s++;
                e--;
                continue;
            }
            if (nums[m] >= nums[s]) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}
