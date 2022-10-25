public class Solution1 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < bits.length; i++) {
                bits[i] += num >> i & 1;
            }
        }
        int res = 0;
        for (int i = 0; i < bits.length; i++) {
            res += bits[i] % 3 << i;
        }
        return res;
    }
}
