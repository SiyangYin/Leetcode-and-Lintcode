import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param str: The input string
     * @return: The answer
     */
    public String[] dataSegmentation(String str) {
        // Write your code here
        List<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ' && !Character.isLetter(ch)) {
                list.add(String.valueOf(ch));
            } else if (Character.isLetter(ch)) {
                int j = i;
                while (j < str.length() && Character.isLetter(str.charAt(j))) {
                    j++;
                }
                
                list.add(str.substring(i, j));
                i = j - 1;
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dataSegmentation("(hi (i am)bye")));
    }
}
