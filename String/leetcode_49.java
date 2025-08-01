package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_49 {
    public static void main(String[] args) {
        String [] s = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(Arrays.deepToString(anagramGroup(s)));
    }

    public static Object[] anagramGroup(String[] st){
        int n = st.length;
        boolean [] visited = new boolean[n];
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                List<String> curr = new ArrayList<>(List.of(st[i]));

                for(int j = i+1;j<n;j++){
                    if(isAnagram(st[i],st[j])){
                        curr.add(st[j]);
                        visited[j] = true;
                    }
                }

                ans.add(curr);
            }
        }
        return new List[]{ans};
    }

    public static boolean isAnagram(String s1, String s2){
        int []freq = new int[26];
        int []freq1 = new int[26];

        if(s1.length()==s2.length()){
            for(char ch : s1.toCharArray()){
                freq[ch-'a']++;
            }

            for(char ch1 : s2.toCharArray()){
                freq1[ch1-'a']++;
            }

            for(int i = 0;i<26;i++){
                if(freq[i]!=freq1[i]){
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
