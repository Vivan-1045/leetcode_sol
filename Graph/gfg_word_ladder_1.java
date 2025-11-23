package Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class gfg_word_ladder_1 {
    class Pair{
        String word;
        int steps;
        Pair(String s, int n){
            this.word=s;
            this.steps = n;
        }
    }
    public int wordLadderLength(String startWord, String targetWord,String[] wordList) {
        // Code here

        return wordStepLen(startWord,targetWord,wordList);
    }

    int wordStepLen(String start,String tWord , String[] word){
        Set<String> st = new HashSet<>();

        for(String s: word){
            st.add(s);
        }

        if(!st.contains(tWord)){
            return 0;
        }

        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(start,1));

        st.remove(start);

        while(!que.isEmpty()){
            String curr = que.peek().word;
            int step = que.peek().steps;
            que.remove();

            if(curr.equals(tWord)){
                return step;
            }

            for(int i = 0;i<curr.length();i++){
                for(char ch = 'a';ch<='z';ch++){
                    char[] chaArr = curr.toCharArray();
                    chaArr[i] = ch;

                    String currSt = new String(chaArr);

                    if(st.contains(currSt)){
                        st.remove(currSt);
                        que.offer(new Pair(currSt,step+1));
                    }
                }
            }
        }

        return 0;
    }
}
