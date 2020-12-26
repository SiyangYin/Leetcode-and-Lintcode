public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        String shortest = null;
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
                shortest = s;
            }
        }
        
        if (shortest == null || shortest.isEmpty()) {
            return "";
        }
        
        int l = 0, r = shortest.length() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (isPrefix(strs, shortest.substring(0, m + 1))) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        String res = shortest.substring(0, l + 1);
        return isPrefix(strs, res) ? res : "";
    }
    
    private boolean isPrefix(String[] strs, String s) {
        for (String str : strs) {
            if (!str.startsWith(s)) {
                return false;
            }
        }
        return true;
    }
}
