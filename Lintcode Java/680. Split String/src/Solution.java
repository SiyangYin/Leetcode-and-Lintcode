import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(String s, int pos, List<String> cur, List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; i < pos + 2 && i < s.length(); i++) {
            cur.add(s.substring(pos, i + 1));
            dfs(s, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().splitString("12345"));
        System.out.println(new Solution().splitString(""));
    }
}
