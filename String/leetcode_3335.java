package String;

public class leetcode_3335 {
    static int M = 1_000_000_007;
    public static void main(String[] args) {
        String s ="absxyz";
        int t = 3;
        System.out.println(maxLength(s,t));
    }
    public static int maxLength(String s,int t){
        int [] arr1 = new int[26];
        for (char ch : s.toCharArray()){
            arr1[ch-'a']++;
        }

        for (int trans = 1;trans<=t;trans++){
            int temp[] = new int[26];

            for (int i =0;i<26;i++){
                char ch1 = (char) (i+'a');
                int freq = arr1[i];

                if (ch1 != 'z'){
                    temp[(ch1 + 1) - 'a'] = (temp[(ch1 + 1) - 'a'] + freq) % M;
                }
                else{
                    temp['a' - 'a'] = (temp['a' - 'a'] + freq) % M;
                    temp['b' - 'a'] = (temp['b' - 'a'] + freq) % M;
                }
            }
            arr1 = temp;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + arr1[i]) % M;
        }

        return result;
    }
}
