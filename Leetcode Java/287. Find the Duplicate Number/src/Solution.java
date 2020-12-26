public class Solution {
    public int findDuplicate(int[] nums) {
//        Floyd tortoise and hare
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);
        
        
        int ptr1 = nums[0];
        int ptr2 = tortoise;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().findDuplicate(new int[]{1, 1, 2, 3}));
        System.out.println(new Solution().findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
