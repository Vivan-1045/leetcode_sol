package Maths;

public class leetcode_1390 {
    public int sumFourDivisors(int[] nums) {
        return sumFour(nums);
    }
    int sumFour(int[]arr){
        int res = 0;

        int n = arr.length;
        for(int i = 0;i<n;i++){
            int currSum = 0;
            int divCnt = 0;

            for(int j = 1;j*j<=arr[i];j++){
                if(arr[i]%j==0){
                    int div1 = j;
                    int div2 = arr[i]/j;

                    if(div1==div2){
                        divCnt++;
                        currSum += div1;
                    }else{
                        divCnt += 2;
                        currSum += div1 + div2;
                    }

                    if(divCnt>4){
                        break;
                    }
                }
            }

            if(divCnt==4){
                res += currSum;
            }

        }

        return res;

    }
}
