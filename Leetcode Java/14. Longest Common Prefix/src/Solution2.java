public class Solution2 {
    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "flower";
        strs[1] = "flow";
        strs[2] = "flo";
        
        strs = new String[]{""};
        System.out.println(new Solution2().longestCommonPrefix(strs));
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String shortest = strs[0];
        int minLen = shortest.length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                shortest = strs[i];
            }
        }
        
        if (shortest.length() == 0) {
            return "";
        }
        
        int l = 0, r = shortest.length() - 1;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (checkPrefix(strs, shortest.substring(0, mid + 1))) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        String res = shortest.substring(0, l + 1);
        return checkPrefix(strs, res) ? res : "";
    }
    
    private boolean checkPrefix(String[] strs, String prefix) {
        for (String str : strs) {
            if (!str.startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}
