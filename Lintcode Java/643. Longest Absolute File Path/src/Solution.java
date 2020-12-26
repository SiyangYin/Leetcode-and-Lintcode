import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // write your code here
        String[] strs = input.split("\n");
        Map<Integer, Integer> levelSize = new HashMap<>();
        levelSize.put(-1, 0);
    
        int res = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int level = str.lastIndexOf('\t') + 1;
            int len = str.length() - level;
            
            if (str.contains(".")) {
                res = Math.max(res, levelSize.get(level - 1) + len);
            } else {
                levelSize.put(level, levelSize.get(level - 1) + len + 1);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int i = new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
        System.out.println(i);
    }
}
