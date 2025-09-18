package Two_Pointer;

public class leetcode_31 {
    public void nextPermutation(int[] nums) {
        nextPerm(nums);
    }

    void nextPerm(int[] arr){
        int idx = -1;

        for(int i = arr.length-1;i>0;i--){
            if(arr[i-1]<arr[i]){
                idx = i-1;
                break;
            }
        }

        if(idx != -1){
            int swapIdx = idx;

            for(int i=arr.length-1;i>=idx+1;i--){
                if(arr[i]>arr[idx]){
                    swapIdx = i;
                    int temp = arr[swapIdx];
                    arr[swapIdx] = arr[idx];
                    arr[idx] = temp;
                    break;
                }
            }
        }

        swap(arr,idx+1,arr.length-1);
    }

    void swap(int[]arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
