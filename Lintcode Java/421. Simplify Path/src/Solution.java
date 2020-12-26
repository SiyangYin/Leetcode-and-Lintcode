public class Solution {
    /**
     * @param path: the original path
     * @return: the simplified path
     */
    public String simplifyPath(String path) {
        // write your code here
        if (path == null || path.isEmpty()) {
            return "/";
        }
        
        String[] split = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.isEmpty()) {
                continue;
            }
            
            if ("..".equals(s)) {
                if (sb.length() == 0) {
                    continue;
                }
                
                sb.setLength(sb.lastIndexOf("/"));
            } else if (!".".equals(s)) {
                sb.append('/').append(s);
            }
        }
        
        return sb.length() == 0 ? "/" : sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/a/./../../c/"));
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    }
}
