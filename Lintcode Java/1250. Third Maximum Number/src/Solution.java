import java.util.TreeSet;

public class Solution {
    /**
     * @param nums: the array
     * @return: the third maximum number in this array
     */
    public int thirdMax(int[] nums) {
        // Write your code here.
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() < 3) {
                set.add(nums[i]);
            } else {
                if (nums[i] > set.first() && !set.contains(nums[i])) {
                    set.pollFirst();
                    set.add(nums[i]);
                }
            }
        }
        
        return set.size() == 3 ? set.first() : set.last();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().thirdMax(new int[]{1, 2, 3}));
        System.out.println(new Solution().thirdMax(new int[]{1, 1, 2, 3}));
        System.out.println(new Solution().thirdMax(new int[]{2, 2, 3, 1}));
    }
}
