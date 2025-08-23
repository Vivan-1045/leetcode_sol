package BinaryTree.BFS;

import java.util.*;

public class leetcode_127 {
    public static void main(String[] args) {
        String []wdList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(minLadderLength("hit","cog",Arrays.asList(wdList)));
    }

    public static int minLadderLength(String beWord , String edWord , List<String> wdList){
        Set<String> wordSet = new HashSet<>(wdList);
        if(!wordSet.contains(edWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beWord);
        visited.add(beWord);

        int ldLength = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ldLength++;

            for(int i = 0;i<size;i++){
                String curr = queue.poll();

                for(int j = 0;j<curr.length();j++){
                    char[] temp = curr.toCharArray();

                    for(char c = 'a';c<='z';c++){
                        temp[j] = c;

                        String newWord = new String(temp);
                        if(newWord.equals(edWord)){
                            return ldLength+1;
                        }

                        if(wordSet.contains(newWord) && !visited.contains(newWord)){
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }

        return 0;
    }
}
