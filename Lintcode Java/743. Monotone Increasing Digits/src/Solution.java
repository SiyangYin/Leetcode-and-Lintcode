public class Solution {
    /**
     * @param num: a non-negative integer N
     * @return: the largest number that is less than or equal to N with monotone increasing digits.
     */
    public int monotoneDigits(int num) {
        // write your code here
        String s = String.valueOf(num);
        int[] n = new int[s.length()];
        for (int i = 0; i < n.length; i++) {
            n[i] = s.charAt(i) - '0';
        }
    
        boolean reversed = false;
        for (int i = 0; i < n.length - 1; i++) {
            if (n[i] > n[i + 1]) {
                reversed = true;
                break;
            }
        }
        
        if (!reversed) {
            return num;
        }
        
        for (int i = 0; i < n.length - 1; i++) {
            if (n[i] >= n[i + 1]) {
                n[i]--;
                for (int j = n.length - 1; j > i; j--) {
                    n[j] = 9;
                }
                
                return recover(n);
            }
        }
        
        return num;
    }
    
    private int recover(int[] n) {
        int res = 0;
        for (int i = 0; i < n.length; i++) {
            res *= 10;
            res += n[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().monotoneDigits(10));
        System.out.println(new Solution().monotoneDigits(123));
        System.out.println(new Solution().monotoneDigits(10000));
        System.out.println(new Solution().monotoneDigits(999));
    }
}
