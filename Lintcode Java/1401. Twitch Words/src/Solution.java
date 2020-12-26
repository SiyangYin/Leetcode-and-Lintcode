import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        // Write your code here
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char ch = str.charAt(i);
            if (ch == str.charAt(i + 1)) {
                int j = i + 1;
                while (j < str.length() && str.charAt(j) == ch) {
                    j++;
                }
                
                if (j - i >= 3) {
                    list.add(new int[]{i, j - 1});
                }
                i = j - 1;
            }
        }
        
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().twitchWords("whaaaaatttsup")));
    }
}
