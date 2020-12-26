public class Solution {
    /**
     * @param m: a integer
     * @param n: a integer
     * @param k: a integer
     * @return: return a integer
     */
    public int findKthNumber(int m, int n, int k) {
        // write your code here
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l >> 1);
            
            int count = 0;
            int x = m, y = 1;
            while (x >= 1 && y <= n) {
                int p = x * y;
                if (p <= mid) {
                    count += x;
                    y++;
                } else {
                    x--;
                }
            }
            
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findKthNumber(3, 3, 5));
    }
}
