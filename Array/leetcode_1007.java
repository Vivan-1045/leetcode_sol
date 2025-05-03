package Array;

public class leetcode_1007 {
    public static void main(String[] args) {
        int []arr1={2,1,1,3,2,1,2,2,1};
        int []arr2={3,2,3,1,3,2,3,3,2};
        System.out.println(minSwapToMakeDominoHalvesEqual(arr1,arr2));

    }
    public static int minSwapToMakeDominoHalvesEqual(int []top,int[]bottom){
//        int ans = Integer.MAX_VALUE;
//        int swaps = 0;
//        for(int i=1;i<=6;i++){
//           swaps = isPossible(i,top,bottom);
//           if (swaps != -1){
//               ans = Math.min(ans,swaps);
//           }
//        }
//        return ans==Integer.MAX_VALUE?-1:ans;

        int ans = isPossible(top[0],top,bottom);
        if (ans != -1){
            return ans;
        }
        return isPossible(bottom[0],top,bottom);

    }
    public static int isPossible(int target, int[] arr1,int[] arr2){
        int swapTop = 0;
        int swapBot = 0;

        int n = arr1.length;
        for (int i =0;i<n;i++){
            if (target != arr1[i] && target != arr2[i]){
                return -1;
            }
            if (target != arr1[i]){
                swapBot++;
            }
            if (target != arr2[i]){
                swapTop++;
            }

        }
        return Math.min(swapTop,swapBot);
    }
}


//[2,1,2,4,2,2]
//        [5,2,6,2,3,2]
//        [3,5,1,2,3]
//        [3,6,3,3,4]
//        [2,2,2,2,2]
//        [2,3,2,3,5]
//        [4,4,4,4]
//        [2,2,2,2]
//        [4,4,2,4]
//        [2,2,2,4]
//        [4,2,2,4]
//        [2,2,2,2]
//        [4,2,2,4]
//        [2,4,4,2]
//        [4,2]
//        [2,4]