public class Solution2 {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int cur = 0;
        while (cur != slow) {
            cur = nums[cur];
            slow = nums[slow];
        }
        return cur;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution2().findDuplicate(new int[]{1, 3, 4, 2, 2}));
        // System.out.println(new Solution2().findDuplicate(new int[]{3, 1, 3, 4, 2}));
        System.out.println(new Solution2().findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }
}
