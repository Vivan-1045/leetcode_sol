public class weekly {
    public static void main(String[] args) {
        int [] arr = {2,3,4,5,6};

        System.out.println(MaxLenSubArr(arr));
    }
    public static int GCD(int a, int b){
        if(a==0){
            return b;
        }
        return GCD(b%a,a);
    }
    public static int LCM(int a, int b){
        return a*b / GCD(a,b);
    }
    public static int MaxLenSubArr(int[] arr){
        int n = arr.length;
        int maxlength = 0;
        for(int i = 0;i<n;i++){
            int currGCD = arr[i];
            int currLCM = arr[i];
            int pro = 1;
            for(int j = i;j<n;j++){
                pro *= arr[j];
                currGCD = GCD(currGCD,arr[j]);
                currLCM = LCM(currLCM,arr[j]);

                if(pro == currGCD * currLCM){
                    maxlength = Math.max(maxlength,j-i+1);
                }
            }
        }
        return maxlength;
    }
}
