package Maths;

import java.util.ArrayList;
import java.util.List;

public class leetcode_2125 {
    public int numberOfBeams(String[] bank) {
        return numberOfBeam1(bank);
    }

    int numberOfBeam(String[] bank){
        int n = bank.length;
        if(n==1){
            return 0;
        }

        int res = 0;

        for(int i = 0;i<n-1;i++){
            int currOne = OneCnt(bank[i]);

            if(currOne>0){
                int nextOne = 0;
                for(int j = i+1;j<n;j++){
                    nextOne = OneCnt(bank[j]);
                    if(nextOne != 0){
                        break;
                    }
                }

                res += currOne*nextOne;
            }
        }

        return res;
    }

    int OneCnt(String s){
        int res = 0;
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                res +=1;
            }
        }

        return res;
    }

    int numberOfBeam1(String []s){
        List<Integer> ls = new ArrayList<>();

        for(int i = 0;i<s.length;i++){
            int oneCnt = OneCnt(s[i]);
            if(oneCnt != 0){
                ls.add(oneCnt);
            }
        }
        if(ls.size()==1){
            return 0;
        }

        int res = 0;

        for(int i = 0;i<ls.size()-1;i++){
            res += ls.get(i)*ls.get(i+1);
        }
        return res;
    }
}
