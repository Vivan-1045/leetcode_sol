package Algos;


public class Mos_Algo {
    static int sqrt;
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9};

        sqrt = (int)Math.sqrt(arr.length);
        int []block = MosAlgo(arr);

        update(block,arr,4,25,sqrt);

        System.out.println(qureySum(block,arr,2,6,sqrt));
    }

    public static int[] MosAlgo(int[] arr){
        int n = arr.length;
        int blockIdx = -1;
        int[]blocks = new int[sqrt+1];

        for (int i =0;i<n;i++){
            if (i%sqrt == 0){
                blockIdx++;
            }
            blocks[blockIdx] += arr[i];
        }

        return blocks;
    }

    public static int qureySum(int[] block,int[] arr, int s, int e,int sqrt){
        int ans = 0;

        //Left-part
        while (s%sqrt != 0 && s != 0 && s<e){
            ans += arr[s];
            s++;
        }

        //Mid-part
        while (s+sqrt<e){
            ans += block[s%sqrt];
            s += sqrt;
        }

        //Right-part
        while (s<=e){
            ans+= arr[s];
            s++;
        }
        return ans;
    }

    public static void update(int[] blocks, int[] arr, int idx , int val,int sqrt){
        int blockIdx = idx%sqrt;
        blocks[blockIdx] += (val - arr[idx]);
        arr[idx]= val;
    }
}
