public class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (i == -1 || nums[j] != nums[i] ) {
                i++;
                nums[i] = nums[j];
                
            }
        }
        return i + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(Solution.removeDuplicates(new int[]{1, 1, 2}));
    }
}
