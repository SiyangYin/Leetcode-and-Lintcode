public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        for (int t : time) {
            count[t % 60]++;
        }
    
        int res = 0;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) {
                res += count[i] * (count[i] - 1) / 2;
            } else {
                res += count[i] * count[60 - i];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(new Solution().numPairsDivisibleBy60(new int[]{30, 20, 30, 40, 40}));
    }
}
