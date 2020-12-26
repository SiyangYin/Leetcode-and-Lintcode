import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");
        for (String s : dirs) {
            if (s.length() == 0) {
                continue;
            }
            if (!".".equals(s) && !"..".equals(s)) {
                stack.push(s);
            } else if ("..".equals(s) && !stack.isEmpty()) {
                stack.pop();
            }
        }
        
        StringBuilder res = new StringBuilder();
        
        while (!stack.isEmpty()) {
            res.append('/');
            res.append(stack.pollLast());
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
