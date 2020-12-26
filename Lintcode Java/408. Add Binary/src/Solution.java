public class Solution {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int d = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0;) {
            if (i >= 0) {
                d += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                d += b.charAt(j) - '0';
                j--;
            }
            
            sb.append(d % 2);
            d /= 2;
        }
        
        if (d == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("101111", "10"));
    }
}
