package Graph;

import java.util.*;

public class leetcode_2115 {
    public static void main(String[] args) {
        String []racipe = {"bread"};
        List<List<String>> ingrediant = new ArrayList<>();
        String[] supplies = {"yeast","flour","meat"};
        System.out.println(possileracipe(racipe,ingrediant,supplies));
    }
    public static List<String> possileracipe(String[] racipe,List<List<String>> ingrediant,String[] supplies){
            int n = racipe.length;
            int count = n;
            Set<String> supply = new HashSet<>(Arrays.asList(supplies));
            List<String> ans= new ArrayList<>();

            boolean []cooked = new boolean[n];

            while(count>0){
                boolean progress = false;

                for(int j = 0;j<n;j++){
                    if(cooked[j]){
                        continue;
                    }

                    boolean canMake = true;
                    for(String ingred:ingrediant.get(j)){
                        if(!supply.contains(ingred)){
                            canMake = false;
                            break;
                        }
                    }

                    if(canMake){
                        supply.add(racipe[j]);
                        ans.add(racipe[j]);
                        cooked[j] = true;
                        progress = true;
                        count--;
                    }
                }

                if(!progress){
                    break;
                }

            }
            return ans;
        }
}
