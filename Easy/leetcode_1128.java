package Easy;
public class leetcode_1128 {
    public static void main(String[] args) {
        int [][] arr = {{1,2},{2,1},{3,4},{5,6},{1,2}};
        System.out.println(equalPair(arr));
    }
    public static int equalPair(int[][] arr){
        int count  =0;
        for (int i = 0;i<arr.length-1;i++){
            int a = arr[i][0];
            int b = arr[i][1];
            for (int j = i+1;j<arr.length;j++){
                int c= arr[j][0];
                int d= arr[j][1];

                if (a==c && b==d || a==d && b==c){
                    count ++;
                }
            }
        }
        return count;
    }
}
