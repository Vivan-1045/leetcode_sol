package Bit_Manipulation;

public class leetcode_318 {
    public int maxProduct(String[] words) {
        return getMax(words);
    }

    //TLE 167/168
    int maxlen(String[]arr){
        int ans = 0;
        int n = arr.length;

        for(int i = 0;i<n;i++){
            String s = arr[i];
            // int curr = s.length();
            for(int j = i+1;j<n;j++){
                if(isUnique(s,arr[j])){
                    int curr = s.length();
                    curr = Math.max(curr*arr[j].length(),curr);

                    ans = Math.max(ans,curr);
                }

            }
        }

        return ans;
    }

    public boolean isUnique(String s1,String s2){
        int n = Math.min(s1.length(),s2.length());

        if(n==s1.length()){
            for(int i = 0;i<n;i++){
                if(s2.contains(s1.charAt(i)+"")){
                    return false;
                }
            }
            return true;
        }

        for(int i = 0;i<n;i++){
            if(s1.contains(s2.charAt(i)+"")){
                return false;
            }
        }
        return true;
    }

    //Approach : Create a bit representation of each word in the given array
    //take bitwise AND of two words if AND == 0 means no any common character is found in both the words.
    //Then calculate the product of their length

    int getMax(String[]arr){
        int[] bit = new int[arr.length];
        int ans = 0;

        for(int i = 0;i<arr.length;i++){
            for(char ch : arr[i].toCharArray()){
                bit[i] |= 1<<(ch-'a');
            }

            for(int j = 0;j<i;j++){
                if((bit[i]&bit[j])==0){
                    int curr = arr[i].length()*arr[j].length();

                    ans = Math.max(ans,curr);
                }
            }
        }

        return ans;
    }
}
