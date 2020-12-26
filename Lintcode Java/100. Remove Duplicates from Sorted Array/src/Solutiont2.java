public class Solutiont2 {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
    
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (j == 0 || nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        
        return i + 1;
    }
}
