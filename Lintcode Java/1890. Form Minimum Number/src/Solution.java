public class Solution {
    /**
     * @param str: the pattern
     * @return: the minimum number
     */
    public String formMinimumNumber(String str) {
        // Write your code here.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() + 1; i++) {
            sb.append(i + 1);
        }
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'D') {
                int j = i;
                while (j < str.length() && str.charAt(j) == 'D') {
                    j++;
                }
                
                reverse(sb, i, j);
                
                i = j;
            }
        }
        
        return sb.toString();
    }
    
    private void reverse(StringBuilder sb, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().formMinimumNumber("DIDI"));
        System.out.println(new Solution().formMinimumNumber("D"));
    }
}
