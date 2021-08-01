public class Solution {
    public int specialArray(int[] nums) {
        int[] cnt = new int[1001];
        for (int x : nums) {
            cnt[x]++;
        }
    
        int c = 0;
        for (int i = 0; i <= 1000; i++) {
            if (nums.length - c == i) {
                return i;
            }
            
            c += cnt[i];
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().specialArray(new int[]{3, 5}));
    }
}
