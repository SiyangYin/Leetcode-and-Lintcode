public class Solution {
    /**
     * @param k: The k
     * @param a: The A
     * @param b: The B
     * @return: The answer
     */
    public String addition(int k, String a, String b) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        int t = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; ) {
            if (i >= 0) {
                t += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                t += b.charAt(j) - '0';
                j--;
            }
            sb.append(t % k);
            t /= k;
        }
        if (t > 0) {
            sb.append(1);
        }
        
        for (int i = sb.length() - 1; i >= 1; i--) {
            if (sb.charAt(i) != '0') {
                sb.setLength(i + 1);
                break;
            }
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().addition(3, "12", "1"));
    }
}
