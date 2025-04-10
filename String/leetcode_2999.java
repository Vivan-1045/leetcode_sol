package String;

public class leetcode_2999 {
    public static void main(String[] args) {
        long st = 15;
        long fin = 215;
        String s = "10";
        int lim = 6;
        System.out.println(powerFullInt(st,fin,s,lim));
    }
    public static long powerFullInt(long start,long finish,String s,int limit){
        String st = Long.toString(start-1);
        String fini = Long.toString(finish);

        return Solution(fini,s,limit) - Solution(st,s,limit);
    }

    public static long Solution(String str,String inPutString ,int limit ){
        if (str.length()<inPutString.length()){
            return 0;
        }

        long count  =0;
        // Extracting last digit to compare last edge case eg. str = 215 , inPutString = 10
        String lastValue = str.substring(str.length()-inPutString.length());  // 15

        //Calculate the remaining digit that are to be placed
        int remainLength = str.length()-inPutString.length();

        //Calculate how much number formed by placing digit on that remaining places
        for (int i =0;i<remainLength;i++){
            int digit =  str.charAt(i)-'0';

            if (digit<=limit){
                count += (long) (digit * (Math.pow(limit+1,remainLength-i-1)));
            }else{
                count += (long) Math.pow(limit+1,remainLength-i);
                return count;
            }
        }

        if (Integer.parseInt(lastValue)>= Integer.parseInt(inPutString)){
            count +=1;

        }
        return count;
    }
}
