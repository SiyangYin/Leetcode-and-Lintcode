public class Solution {
    /**
     * @param s: the string
     * @param k: the integer k
     * @return: the answer
     */
    public String reverseStringII(String s, int k) {
        // Write your code here.
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            reverse(str, i, i + k - 1);
        }
        
        return new String(str);
    }
    
    private void reverse(char[] s, int i, int j) {
        j = Math.min(j, s.length - 1);
        for (; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStringII("abcdefg", 2));
    }
}
