public class Solution {
    /**
     * @param str:
     * @return: the max sum you can add
     */
    public int addCharacter(String str) {
        // Write your code here.
        if (str == null || str.isEmpty()) {
            return 2;
        }
        
        int res = 0;
        for (int i = 0, j; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                j = i;
                while (j < str.length() && str.charAt(j) == 'a') {
                    j++;
                }
                
                res += 2 - (j - i);
                i = j;
            }
        }
        
        if (str.charAt(0) != 'a') {
            res += 2;
        }
        if (str.charAt(str.length() - 1) != 'a') {
            res += 2;
        }
        
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) != 'a' && str.charAt(i + 1) != 'a') {
                res += 2;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addCharacter("abab"));
    }
}
