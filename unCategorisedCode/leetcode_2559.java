package unCategorisedCode;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode_2559 {
    public static void main(String[] args) {
        String []word = {"b","rmivyakd","kddwnexxssssnvrske","vceguisunlxtldqenxiyfupvnsxdubcnaucpoi","nzwdiataxfkbikbtsjvcbjxtr","wlelgybcaakrxiutsmwnkuyanvcjczenuyaiy","eueryyiayq","bghegfwmwdoayakuzavnaucpur","ukorsxjfkdojcxgjxgmxbghno","pmgbiuzcwbsakwkyspeikpzhnyiqtqtfyephqhl","gsjdpelkbsruooeffnvjwtsidzw","ugeqzndjtogxjkmhkkczdpqzwcu","ppngtecadjsirj","rvfeoxunxaqezkrlr","adkxoxycpinlmcvmq","gfjhpxlzmokcmvhjcrbrpfakspscmju","rgmzhaj","ychktzwdhfuruhpvdjwfsqjhztshcxdey","yifrzmmyzvfk","mircixfzzobcficujgbj","d","pxcmwnqknyfkmafzbyajjildngccadudfziknos","dxmlikjoivggmyasaktllgmfhqpyznc","yqdbiiqexkemebyuitve"};
        int [][] query = {{5, 21}};
        System.out.println(Arrays.toString(Word(word, query)));
    }
    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public static int[] Word(String []word,int [][]query){
        int wordInt[] = new int[word.length];
        int i = 0;
        for (String st: word) {
            char firstVowel = st.charAt(0);
            char lastVowel = st.charAt(st.length()-1);

            if (isVowel(firstVowel) && isVowel(lastVowel) ){
                wordInt[i] = 1;
                i++;
            }else{
                wordInt[i] = 0;
                i++;
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        for (int[] idx:query){
            int sum = 0;
            for (int j = idx[0];j<=idx[1];j++){
                sum += wordInt[j];
            } al.add(sum);
        }
        int ans[] = new int[al.size()];
        for (int k = 0;k< al.size();k++){
            ans[k] = al.get(k);
        }
        return ans;
    }
}
