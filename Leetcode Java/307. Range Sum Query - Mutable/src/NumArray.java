public class NumArray {
    
    class FenwickTree {
        
        private int[] tree;
    
        public FenwickTree(int[] nums) {
            tree = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }
        
        private int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            
            return res;
        }
        
        private void add(int i, int d) {
            while (i < tree.length) {
                tree[i] += d;
                i += lowbit(i);
            }
        }
        
        private int lowbit(int x) {
            return x & -x;
        }
    }
    
    private FenwickTree fenwickTree;
    private int[] nums;
    
    public NumArray(int[] nums) {
        fenwickTree = new FenwickTree(nums);
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        fenwickTree.add(i + 1, val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return fenwickTree.sum(j + 1) - fenwickTree.sum(i);
    }
    
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{1, 3, 5});
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}
