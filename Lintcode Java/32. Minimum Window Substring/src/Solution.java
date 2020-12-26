public class Solution {
    /**
     * @param source  : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code here
        // if (target.isEmpty()) {
        //     return "";
        // }
        
        int[] tarCount = new int[256], count = new int[256];
        for (int i = 0; i < target.length(); i++) {
            tarCount[target.charAt(i)]++;
        }
        
        int minLen = Integer.MAX_VALUE;
        String res = "";
        for (int j = 0, i = 0; j < source.length(); j++) {
            count[source.charAt(j)]++;
            while (i <= j && isBigger(count, tarCount)) {
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    res = source.substring(i, j + 1);
                }
                
                count[source.charAt(i)]--;
                i++;
            }
        }
        
        return res;
    }
    
    private boolean isBigger(int[] count, int[] tarCount) {
        for (int i = 0; i < 256; i++) {
            if (count[i] < tarCount[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("abc", "ac"));
        System.out.println(new Solution().minWindow("adobecodebanc", "abc"));
        System.out.println(new Solution().minWindow("absdfaabab", "adb"));
        System.out.println(new Solution().minWindow("ab", ""));
    }
}
