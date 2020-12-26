import java.util.Arrays;

public class Solution {
    /**
     * @param s: a string
     * @return: the number of segments in a string
     */
    public int countSegments(String s) {
        // write yout code here
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            
            res++;
            i = j - 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString("  ".split(" +")));
    }
}
