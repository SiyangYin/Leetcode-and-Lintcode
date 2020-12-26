public class Solution {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        String res = "1";
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < res.length(); ) {
                int k = j;
                char val = res.charAt(j);
                while (k < res.length() && res.charAt(k) == val) {
                    k++;
                }
                
                sb.append(k - j).append(val);
                j = k;
            }
            
            res = sb.toString();
            sb.setLength(0);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(5));
    }
}
