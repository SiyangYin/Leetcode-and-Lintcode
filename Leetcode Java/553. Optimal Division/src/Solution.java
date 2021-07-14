public class Solution {
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        if (nums.length == 1) {
            sb.append(nums[0]);
            return sb.toString();
        } else if (nums.length == 2) {
            sb.append(nums[0]).append('/').append(nums[1]);
            return sb.toString();
        }
        
        sb.append(nums[0]).append('/').append('(');
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]).append('/');
        }
        sb.setCharAt(sb.length() - 1, ')');
        return sb.toString();
    }
}
