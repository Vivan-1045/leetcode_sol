package Hard;

//Also see leetcode 390 similar but different

public class leetcode_3782 {
    public long lastInteger(long n) {
        return lastNum(n);
    }

    long lastNum(long n){
        long head =1;
        long step =1;
        long remaining = n;
        boolean left = true;

        while(remaining > 1){
            if(!left && remaining%2==0){
                head+=step;
            }

            remaining -= remaining/2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}
