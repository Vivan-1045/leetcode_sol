package Graph;

import java.util.*;

public class gfg_word_ladder_2 {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        return ladderSeq(startWord,targetWord,wordList);
    }
    ArrayList<ArrayList<String>> ladderSeq(String start, String targetWord,String[] wordList){
        Set<String> st = new HashSet<>();
        for(String s:wordList){
            st.add(s);
        }

        ArrayList<String> ls = new ArrayList<>();
        ls.add(start);
        Queue<ArrayList<String>> que = new LinkedList<>();
        que.offer(ls);

        ArrayList<String> usedWord = new ArrayList<>();
        usedWord.add(start);
        int level = 0;

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        while(!que.isEmpty()){
            ArrayList<String> curr = que.peek();
            que.remove();

            //Remove the words that are used in each level
            if(curr.size()>level){
                level++;
                for(String s : usedWord){
                    st.remove(s);
                }
                usedWord.clear();
            }

            String s = curr.get(curr.size()-1);
            //For storing the answer
            if(s.equals(targetWord)){
                if(ans.size()==0){
                    ans.add(curr);
                }else if(ans.get(0).size()==curr.size()){
                    ans.add(curr);
                }
            }


            for(int i = 0;i<s.length();i++){

                for(char ch = 'a';ch<='z';ch++){
                    char [] chArr = s.toCharArray();
                    chArr[i] = ch;
                    String replceWord = new String(chArr);
                    if(st.contains(replceWord)){
                        curr.add(replceWord); //Add into curr list
                        ArrayList<String> temp = new ArrayList<>(curr);//Java works by reference
                        que.offer(temp); //Add list to the queue

                        usedWord.add(replceWord); //Also add word as used

                        curr.remove(curr.size()-1); //Remove the previosly added word from curr list
                    }
                }

            }

        }

        return ans;

    }
}
