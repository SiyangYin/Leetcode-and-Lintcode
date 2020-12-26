public class Solution {
    /**
     * @param n: a decimal number
     * @param k: a Integer represent base-k
     * @return: a base-k number
     */
    public String hexConversion(int n, int k) {
        // write your code here
        String dig = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();
        
        do {
            sb.append(dig.charAt(n % k));
            n /= k;
        } while (n > 0);
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().hexConversion(31, 16));
        System.out.println(new Solution().hexConversion(0, 16));
    }
}
