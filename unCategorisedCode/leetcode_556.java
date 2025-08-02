package unCategorisedCode;

public class leetcode_556 {
    public static void main(String[] args) {
        String st = "2147483486";
        char ch [] = st.toCharArray();
        int i = ch.length-2;
        while (i>=0 && ch[i]>=ch[i+1])
            i--;
        if (i==-1){
            System.out.println(-1);
        }
        int j = ch.length-1;
        while (j>i && ch[j] <= ch[i]){
            j--;
        }
        swap(ch, i, j);
        StringBuilder sb = new StringBuilder();
        char[] st1  = reverse(ch, i+1);
        sb.append(st1);
        System.out.println(sb);
    }
    public static void swap(char[] ch1,int a,int b){
        char temp = ch1[a];
        ch1[a] = ch1[b];
        ch1[b] = temp;
    }
    public static char[] reverse(char[] ch1 ,int s){
        int l = s, r= ch1.length-1;
        while (l<r){
            swap(ch1, l, r);
            l++;
            r--;
        }
        return ch1;
    }
}
