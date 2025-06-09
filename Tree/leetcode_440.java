package Tree;

public class leetcode_440 {
    public static void main(String[] args) {
        System.out.println(getKthNumber(10,3));
    }
    public static int getKthNumber(int n,int k){
        int currNum = 1;
        k -= 1;
        while (k>0){
            int count = CountNumber(currNum,currNum+1,n);
            if (count<=k){
                currNum++;
                k -= count; //Skip the next number of that tree
            }else{
                currNum *= 10; // Go into the deeper of that tree;
                k -= 1;
            }
        }
        return currNum;
    }
    public static int CountNumber(long curr , long next , int n){
        int countNumber = 0;
        while (curr<= n){
            countNumber += (int) (next-curr);
            curr *= 10;
            next *= 10;
            next = Math.min(next,(long)n+1);
        }
        return countNumber;
    }
}
