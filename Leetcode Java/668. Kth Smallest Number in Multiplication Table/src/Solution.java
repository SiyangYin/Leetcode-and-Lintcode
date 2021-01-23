public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = l + (r - l >> 1);
            int x = m, y = 1, count = 0;
            while (x >= 1 && y <= n) {
                if (x * y <= mid) {
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
