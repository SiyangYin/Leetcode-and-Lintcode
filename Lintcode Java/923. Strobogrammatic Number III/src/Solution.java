public class Solution {
    
    private int res;
    
    /**
     * @param low: a string
     * @param high: a string
     * @return: the total strobogrammatic numbers that exist in the range of low <= num <= high
     */
    public int strobogrammaticInRange(String low, String high) {
        // Write your code here
        dfs("", low, high);
        dfs("0", low, high);
        dfs("1", low, high);
        dfs("8", low, high);
        return res;
    }
    
    private void dfs(String cur, String low, String high) {
        if (comp(high, cur) < 0) {
            return;
        }
        
        if (comp(low, cur) <= 0 && !(cur.charAt(0) == '0' && cur.length() > 1)) {
            res++;
        }
        
        dfs("0" + cur + "0", low, high);
        dfs("1" + cur + "1", low, high);
        dfs("6" + cur + "9", low, high);
        dfs("9" + cur + "6", low, high);
        dfs("8" + cur + "8", low, high);
    }
    
    private int comp(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return Integer.compare(s1.length(), s2.length());
        }
        
        return s1.compareTo(s2);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().strobogrammaticInRange("0", "0"));
    }
}
