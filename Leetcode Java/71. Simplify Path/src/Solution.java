import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stk = new LinkedList<>();
        String[] dirs = path.split("/");
        for (String s : dirs) {
            if (s.isEmpty()) {
                continue;
            }
            
            if (!".".equals(s) && !"..".equals(s)) {
                stk.push(s);
            } else if ("..".equals(s) && !stk.isEmpty()) {
                stk.pop();
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        while (!stk.isEmpty()) {
            res.append('/');
            res.append(stk.pollLast());
        }
        
        if (res.length() == 0) {
            res.append("/");
        }
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        path = "/home//foo/";
        // path = "/home/";
        // path = "/a//b////c/d//././/..";
        // path = "/../";
        System.out.println(new Solution().simplifyPath(path));
    }
}
