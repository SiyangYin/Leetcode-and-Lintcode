public class Solution {
    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "flo";
        
        strs = new String[]{""};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
    
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCP(strs, 0, strs.length - 1);
    }
    
    private String longestCP(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        
        int mid = l + ((r - l) >> 1);
        String s1 = longestCP(strs, l, mid);
        String s2 = longestCP(strs, mid + 1, r);
    
        int minLen = Math.min(s1.length(), s2.length());
        StringBuilder sb = new StringBuilder(minLen);
        for (int i = 0; i < minLen; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                sb.append(s1.charAt(i));
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}
