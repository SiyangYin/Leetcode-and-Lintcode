public class Solution {
    
    private int idx;
    
    public boolean isValidSerialization(String preorder) {
        idx = 0;
        String[] strs = preorder.split(",");
        return dfs(strs) && idx == strs.length;
    }
    
    private boolean dfs(String[] strs) {
        if (idx == strs.length) {
            return false;
        }
        
        if (strs[idx].equals("#")) {
            idx++;
            return true;
        }
        
        idx++;
        return dfs(strs) && dfs(strs);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution().isValidSerialization("1,#"));
    }
}
