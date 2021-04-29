public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[k];
        for (int x : arr) {
            cnt[(x % k + k) % k]++;
        }
        
        if (cnt[0] % 2 != 0) {
            return false;
        }
        
        for (int i = 1, j = k - 1; i < j; i++, j--) {
            if (cnt[i] != cnt[j]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5));
    }
}
