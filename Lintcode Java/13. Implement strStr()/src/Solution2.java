public class Solution2 {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        for (int i = 0; i + target.length() <= source.length(); i++) {
            int j = 0;
            while (j < target.length() && source.charAt(i + j) == target.charAt(j)) {
                j++;
            }
            if (j == target.length()) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().strStr("abcdabcdefg", "bcd"));
    }
}
