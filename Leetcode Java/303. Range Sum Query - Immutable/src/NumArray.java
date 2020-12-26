public class NumArray {
    
    private int[] prefixSum;
    
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return prefixSum[j] - (i >= 1 ? prefixSum[i - 1] : 0);
    }
    
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
    }
}
