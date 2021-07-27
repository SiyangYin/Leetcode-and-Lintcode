public class Solution {
    public int countTriples(int n) {
        int res = 0;
        for (int i = 5; i <= n; i++) {
            for (int l = 1, r = i - 1; l <= r; ) {
                if (l * l + r * r < i * i) {
                    l++;
                } else if (l * l + r * r > i * i) {
                    r--;
                } else {
                    res += l == r ? 1 : 2;
                    l++;
                    r--;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countTriples(5));
    }
}
