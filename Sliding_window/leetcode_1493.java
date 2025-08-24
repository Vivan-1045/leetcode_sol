package Sliding_window;

public class leetcode_1493 {
    public static void main(String[] args) {
     int[] arr = {1,1,0,0,1,1,1,0,1};
        System.out.println(maxLength2(arr));
    }

    //Brute force
    public static int maxLength(int[] arr){
        int n = arr.length;
        int i = 0;
        int ans = 0;
        int zeroCount = 0;
        for (int j = 0;j<n;j++){
            if (arr[j]==0){
                zeroCount++;
                ans = Math.max(ans,findMax(arr,j));
            }
        }

        if (zeroCount==0){
            return n-1;
        }
        return ans;
    }

    public static int findMax(int[] arr, int idx){
        int maxlength = 0;
        int currLength = 0;

        for(int i = 0;i<arr.length;i++){
            if (i==idx){
                continue;
            }
            if (arr[i]==1){
                currLength++;
                maxlength = Math.max(maxlength,currLength);
            }else{
                currLength = 0;
            }
        }

        return maxlength;
    }

    //Sliding window
    public static int maxLength1(int[] arr){
        int n = arr.length;
        int i = 0;
        int length = 0;
        int zeroCount = 0;

        for (int j = 0;j<n;j++){
            if (arr[j]==0){
                zeroCount++;
            }
            while (zeroCount>1){
                if (arr[i]==0){
                    zeroCount--;
                }
                i++;
            }

            length = Math.max(length,j-i);
        }

        if (zeroCount==0){
            return n-1;
        }

        return length;
    }

    //Best Sliding window
    public static int maxLength2(int[] arr){
        int n = arr.length;
        int zeroCount = 0;
        int max = 0;
        int i = 0;
        int firstZeroIdx = -1;

        for(int j = 0;j<n;j++){
            if(arr[j]==0){
                zeroCount++;
                if(firstZeroIdx == -1){
                    firstZeroIdx = j;
                }
            }
            if(zeroCount>1){
                i = firstZeroIdx+1;
                firstZeroIdx = j;
                zeroCount--;
            }
            max = Math.max(max,j-i);
        }

        return max;
    }
}
