package Algos;

public class Karp_rabin {

    private static final int PRIME = 199;

    private double calculateHash(String s){
        double hash = 0;
        for(int i = 0;i<s.length();i++){
            hash += s.charAt(i) * Math.pow(PRIME,i);
        }
        return hash;
    }

    private double updatedHash(double preHash,char oldChar,char newChar, int length){
        double newHash = (preHash - oldChar)/PRIME;
        newHash = newHash + newChar *Math.pow(PRIME,length-1);
        return newHash;
    }

    public void search(String text , String pattern){
        double hash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0,pattern.length()));

        for(int i = 0;i<= text.length()-pattern.length();i++){
           if (hash==textHash){
               if (text.substring(i,i+pattern.length()).equals(pattern)){
                   System.out.println("pattern found at idx : " + i);
               }
           }
           if (i<text.length()-pattern.length()){
               textHash = updatedHash(textHash,text.charAt(i),text.charAt(i+pattern.length()),pattern.length());
           }
        }
    }

    public static void main(String[] args) {
        Karp_rabin kp = new Karp_rabin();
        kp.search("VivekMohitSumanManjeshUsha", "vivek");

    }

}
