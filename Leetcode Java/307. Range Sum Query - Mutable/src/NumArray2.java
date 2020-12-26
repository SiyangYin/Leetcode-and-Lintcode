public class NumArray2 {
    
    class SegmentTree {
        private int[] tree;
        private int n;
        
        public SegmentTree(int[] nums) {
            tree = new int[nums.length * 4];
            for (int i = 0; i < nums.length; i++) {
                update(0, 0, nums.length - 1, i, nums[i]);
            }
            n = nums.length;
        }
        
        public void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }
        
        private void update(int treeIdx, int l, int r, int idx, int val) {
            if (l == r) {
                tree[treeIdx] = val;
                return;
            }
            
            int m = l + (r - l >> 1);
            if (idx <= m) {
                update(leftChild(treeIdx), l, m, idx, val);
            } else {
                update(rightChild(treeIdx), m + 1, r, idx, val);
            }
            
            tree[treeIdx] = tree[leftChild(treeIdx)] + tree[rightChild(treeIdx)];
        }
        
        public int querySum(int qL, int qR) {
            return querySum(0, 0, n - 1, qL, qR);
        }
        
        private int querySum(int treeIdx, int l, int r, int qL, int qR) {
            if (l == qL && r == qR) {
                return tree[treeIdx];
            }
            
            int m = l + (r - l >> 1);
            if (qR <= m) {
                return querySum(leftChild(treeIdx), l, m, qL, qR);
            } else if (qL >= m + 1) {
                return querySum(rightChild(treeIdx), m + 1, r, qL, qR);
            }
            
            return querySum(leftChild(treeIdx), l, m, qL, m) + querySum(rightChild(treeIdx), m + 1, r, m + 1, qR);
        }
        
        int leftChild(int treeIdx) {
            return treeIdx * 2 + 1;
        }
        
        int rightChild(int treeIdx) {
            return treeIdx * 2 + 2;
        }
    }
    
    SegmentTree segTree;
    
    public NumArray2(int[] nums) {
        segTree = new SegmentTree(nums);
    }
    
    public void update(int i, int val) {
        segTree.update(i, val);
    }
    
    public int sumRange(int i, int j) {
        return segTree.querySum(i, j);
    }
    
    public static void main(String[] args) {
        NumArray2 array = new NumArray2(new int[]{1, 3, 5});
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}
