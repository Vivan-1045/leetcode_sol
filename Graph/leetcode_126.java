package Graph;

import java.util.*;

public class leetcode_126 {
    String b;
    Map<String,Integer> mp;
    List<List<String>> ans;


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        return ladderSeq(beginWord,endWord,wordList);

    }

    List<List<String>> ladderSeq(String begWord,String endWord, List<String> wordList){
        Set<String> st = new HashSet<>(wordList);

        b = begWord;
        Queue<String> que = new LinkedList<>();
        que.offer(begWord);

        mp = new HashMap<>();
        mp.put(begWord,1);
        st.remove(begWord);

        while(!que.isEmpty()){
            String curr = que.poll();
            int step = mp.get(curr);

            if(curr.equals(endWord)){
                break;
            }

            for(int i = 0;i<curr.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char []chArr = curr.toCharArray();
                    chArr[i] = ch;

                    String repWord = new String(chArr);
                    if(st.contains(repWord)){
                        que.offer(repWord);
                        st.remove(repWord);
                        mp.put(repWord,step+1);
                    }
                }
            }
        }

        ans = new ArrayList<>();
        if(mp.containsKey(endWord)){
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord,seq);
        }
        return ans;
    }


    void dfs(String word, List<String> seq){
        if(word.equals(b)){
            List<String> temp = new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int step = mp.get(word);
        for(int i = 0;i<word.length();i++){
            for(char ch = 'a';ch<='z';ch++){
                char []chArr = word.toCharArray();
                chArr[i] = ch;

                String repWord = new String(chArr);
                if(mp.containsKey(repWord) && mp.get(repWord)+1 == step){
                    seq.add(repWord);
                    dfs(repWord,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
}
