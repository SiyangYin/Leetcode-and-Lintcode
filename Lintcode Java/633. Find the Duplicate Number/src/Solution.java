public class Solution {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        // write your code here
        int slow, fast;
        slow = fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int p = 0;
        while (p != slow) {
            p = nums[p];
            slow = nums[slow];
        }
    
        return p;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{5, 5, 4, 3, 2, 1}));
    }
}
