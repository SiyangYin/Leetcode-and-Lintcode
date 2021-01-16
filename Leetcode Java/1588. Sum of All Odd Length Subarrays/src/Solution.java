public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }
        
        int res = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            for (int j = 0; j + i - 1 < arr.length; j++) {
                res += preSum[j + i] - preSum[j];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }
}
