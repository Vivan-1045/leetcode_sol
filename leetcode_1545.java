public class leetcode_1545 {
    public static void main(String[] args) {
        int n = 3;
        int k =9;
        System.out.println(kth(n));
    }
    static int Sn1;
    public static int kth(int n){
        StringBuilder sb = new StringBuilder();
        if (n==0){
           return 0;
        }

        sb.append(kth(n-1));
        sb.append("1");
        sb.append((1^kth(n-1)));


        Sn1 = Integer.parseInt(sb.toString());
        return Sn1;
    }
}
