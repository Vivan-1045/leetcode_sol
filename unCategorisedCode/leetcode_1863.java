package unCategorisedCode;

public class leetcode_1863 {
    public static void main(String[] args) {
        int [] a = {1,3};
        System.out.println(XorSum(a, 0, 0));
    }
    public static int XorSum(int [] nums , int idx, int currXor){
        if (idx>=nums.length){
            return currXor;
        }
        int includeElement = XorSum(nums, idx+1, currXor^nums[idx]);
        int excludeElement = XorSum(nums, idx+1, currXor);
        return  includeElement+excludeElement;
    }
}
