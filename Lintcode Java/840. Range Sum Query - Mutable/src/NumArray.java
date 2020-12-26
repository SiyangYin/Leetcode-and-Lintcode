public class NumArray {
    
    class FenwickTree {
        
        private int[] tree;
        
        public FenwickTree(int[] nums) {
            tree = new int[nums.length + 1];
            
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }
        
        public void add(int i, int d) {
            while (i <= tree.length - 1) {
                tree[i] += d;
                i += lowbit(i);
            }
        }
        
        public int sum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowbit(i);
            }
            
            return sum;
        }
        
        private int lowbit(int x) {
            return x & -x;
        }
    }
    
    FenwickTree tree;
    int[] nums;
    
    public NumArray(int[] nums) {
        tree = new FenwickTree(nums);
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        tree.add(i + 1, val - nums[i]);
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return tree.sum(j + 1) - tree.sum(i);
    }
    
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
