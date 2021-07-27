import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int lengthLongestPath(String s) {
        Deque<Integer> stk = new ArrayDeque<>();
        int res = 0;
        for (int i = 0, tot = 0; i < s.length(); i++) {
            int dep = 0;
            while (i < s.length() && s.charAt(i) == '\t') {
                dep++;
                i++;
            }
            
            while (stk.size() > dep) {
                tot -= stk.pop();
            }
            
            int j = i;
            boolean found = false;
            while (j < s.length() && s.charAt(j) != '\n') {
                if (s.charAt(j) == '.') {
                    found = true;
                }
                
                j++;
            }
            
            tot += j - i;
            stk.push(j - i);
            if (found) {
                res = Math.max(res, tot + stk.size() - 1);
            }
            
            i = j;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(new Solution().lengthLongestPath("a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt"));
    }
}
