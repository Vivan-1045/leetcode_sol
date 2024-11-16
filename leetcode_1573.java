public class leetcode_1573 {
    public static void main(String[] args) {
        String s = "0000";
        int ans = getAns(s);
        System.out.println(ans);
    }
    public static int getAns(String s) {
        long n = s.length();
        long MOD = 1_000_000_007;
        long count1 = 0;
        for (char ch : s.toCharArray()) {
            count1 += ch -'0';
        }
        if (count1 == 0) {
            return (int) ((((n - 1) * (n - 2)) / 2) % MOD);
        }
        if (count1 % 3 != 0) {
            return 0;
        }
        long partition1 = count1 / 3;
        count1 = 0;
        long way1 = 0;
        long way2 = 0;
        for (char ch : s.toCharArray()) {
            count1 += ch -'0';
            if (count1 == partition1) way1++;
            if (count1 == 2 * partition1) way2++;
        }
       return (int) ((way1 * way2) % MOD);
    }
}
