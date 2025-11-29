package Maths;

public class leetcode_2339 {
    public int minMoves(int target, int maxDoubles) {
        return minMove(target,maxDoubles);
    }

    int minMove(int tar, int maxD){
        int move = 0;
        if(tar==1){
            return 0;
        }
        if(maxD==0){
            return tar-1;
        }

        while(tar>1){
            if(maxD==0){
                move += tar-1;
                break;
            }
            if(tar%2==0 && maxD>0){
                tar /=2;
                maxD--;
            }else{
                tar--;
            }
            move++;
        }
        return move;
    }
}
