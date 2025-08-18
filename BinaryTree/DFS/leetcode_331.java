package BinaryTree.DFS;

public class leetcode_331 {
    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(isValidPreOder(s));
    }

    public static boolean isValidPreOder(String s){
        int initialSpace = 1;

        String [] stArray = s.split(",");
        for(int i =0;i<stArray.length;i++){
            if(initialSpace==0){
                return false;
            }
            if(stArray[i].equals("#")){
                initialSpace--;
            }else{
                initialSpace++;
            }
        }

        return initialSpace == 0;
    }
}
