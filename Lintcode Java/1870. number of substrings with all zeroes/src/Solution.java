public class Solution {
    /**
     * @param str: the string
     * @return: the number of substrings
     */
    public int stringCount(String str) {
        // Write your code here.
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '0') {
                int j = i;
                while (j < str.length() && str.charAt(j) == '0') {
                    j++;
                }
                
                res += (j - i) * (j - i - 1) / 2 + (j - i);
                i = j;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().stringCount("00010011"));
    }
}
