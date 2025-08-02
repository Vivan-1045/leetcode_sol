package unCategorisedCode;

public class leetcode_2429 {
    public static void main(String[] args) {
        int A = 1;
        int B = 12;
        System.out.println(ans(A, B));
    }
    public static boolean isSet(int m , int bit){
        return (m & (1<< bit)) != 0;
    }
    public static int setbit(int m, int bit){
        return (m|(1<<bit));
    }
    public static int unset(int m, int bit){
        return m & (~(1<<bit));
    }
    public static int ans(int num1,int num2){
        int m = num1;
        int setBit = Integer.bitCount(m);
        int requiredBit = Integer.bitCount(num2);

        int bit =0;
        if (setBit<requiredBit){
            while (setBit<requiredBit){
                if (!isSet(m,bit)){
                    m = setbit(m,bit);
                    setBit++;
                }
                bit++;
            }
        }
        if (setBit>requiredBit){
            while (setBit>requiredBit){
                if (isSet(m,bit)){
                    m = unset(m,bit);
                    setBit--;
                }
                bit++;
            }
        }
        return m;
    }
}
