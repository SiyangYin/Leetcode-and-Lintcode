public class Solution {
    public int waysToMakeFair(int[] nums) {
        int[] odd = new int[nums.length + 1], even = new int[nums.length  + 1];
        for (int i = 0; i < nums.length; i++) {
            odd[i + 1] = odd[i];
            even[i + 1] = even[i];
            if (i % 2 == 0) {
                even[i + 1] += nums[i];
            } else {
                odd[i + 1] += nums[i];
            }
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (odd[i] + (even[nums.length] - even[i + 1]) == even[i] + (odd[nums.length] - odd[i + 1])) {
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().waysToMakeFair(new int[]{2, 1, 6, 4}));
    }
}
