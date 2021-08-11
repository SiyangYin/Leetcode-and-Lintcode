public class Solution {
    public int numFriendRequests(int[] ages) {
        int res = 0;
        int[] cnt = new int[121];
        for (int age : ages) {
            cnt[age]++;
        }
        
        for (int i = 1; i <= 120; i++) {
            for (int j = 1; j <= 120; j++) {
                if (j > 0.5 * i + 7 && i >= j) {
                    res += i == j ? cnt[i] * (cnt[j] - 1) : cnt[i] * cnt[j];
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numFriendRequests(new int[]{20, 30, 100, 110, 120}));
    }
}
