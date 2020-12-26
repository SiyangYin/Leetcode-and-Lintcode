public class Solution {
    /**
     * @param nums: an array
     * @return: the corresponding expression in string format
     */
    public String optimalDivision(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append('/');
        if (nums.length == 2) {
            return sb.append(nums[1]).toString();
        }
        
        sb.append('(');
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]).append('/');
        }
        
        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().optimalDivision(new int[]{1000, 100, 10, 2}));
    }
}
