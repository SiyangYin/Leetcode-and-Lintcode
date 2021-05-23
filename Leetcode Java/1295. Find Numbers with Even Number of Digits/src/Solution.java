public class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int x : nums) {
            int cnt = 0;
            while (x > 0) {
                cnt++;
                x /= 10;
            }
            
            res += cnt % 2 == 0 ? 1 : 0;
        }
        
        return res;
    }
}
