package Greedy;

public class leetcode_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return canCover1(gas,cost);
    }

    //Brute force
    int canCover(int[]gas, int[]cost){
        int n = gas.length;


        for(int i = 0;i<n;i++){
            int curr = 0;
            boolean found = true;

            for(int j = 0;j<n;j++){
                curr += -cost[(i+j)%n] + gas[(i+j)%n];
                if(curr<0){
                    found = false;
                    break;
                }


            }
            if(found){
                return i;
            }

        }

        return -1;
    }

    //Optimal
    int canCover1(int[] gas, int[]cost){
        int totalGas =0,totalCost = 0;
        int res = -1;

        for(int i = 0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalGas-totalCost<0){
            return res;
        }
        totalGas = 0;
        res = 0;

        for(int i = 0;i<gas.length;i++){
            totalGas = totalGas+gas[i]-cost[i];
            if(totalGas<0){
                totalGas = 0;
                res = i+1;
            }

        }
        return res;
    }
}
