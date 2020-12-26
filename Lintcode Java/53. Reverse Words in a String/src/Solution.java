import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return " ";
        }
        //按照空格将s切分
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        //从后往前遍历array，在sb中插入单词
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
            
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("world war"));
        System.out.println("**********");
    }
}
