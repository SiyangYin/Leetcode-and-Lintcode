public class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] count0 = new int[32], count1 = new int[32];
        for (int num : nums) {
            int idx = 0;
            while (num != 0) {
                if ((num & 1) == 1) {
                    count1[idx]++;
                } else {
                    count0[idx]++;
                }
                
                idx++;
                num >>>= 1;
            }
            while (idx < 32) {
                count0[idx]++;
                idx++;
            }
        }
        
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += count0[i] * count1[i];
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().totalHammingDistance(new int[]{4, 14, 2}));
    }
}
