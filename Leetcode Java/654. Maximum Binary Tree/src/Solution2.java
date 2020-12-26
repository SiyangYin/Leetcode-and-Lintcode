public class Solution2 {
    
    class SegmentTree {
        class Node {
            int max, maxIdx;
            
            public Node() {
            }
        }
        
        private Node[] tree;
        private int n;
        
        public SegmentTree(int[] nums) {
            tree = new Node[4 * nums.length];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node();
            }
            
            for (int i = 0; i < nums.length; i++) {
                update(0, 0, nums.length - 1, i, nums[i]);
            }
            
            n = nums.length;
        }
        
        private void update(int treeIdx, int l, int r, int idx, int val) {
            if (l == r) {
                tree[treeIdx].max = val;
                tree[treeIdx].maxIdx = idx;
                return;
            }
            
            int m = l + (r - l >> 1);
            int lChild = leftChild(treeIdx), rChild = rightChild(treeIdx);
            if (idx <= m) {
                update(lChild, l, m, idx, val);
            } else {
                update(rChild, m + 1, r, idx, val);
            }
            
            int lmax = tree[lChild].max, rmax = tree[rChild].max;
            int lIdx = tree[lChild].maxIdx, rIdx = tree[rChild].maxIdx;
            if (lmax > rmax) {
                tree[treeIdx].max = lmax;
                tree[treeIdx].maxIdx = lIdx;
            } else {
                tree[treeIdx].max = rmax;
                tree[treeIdx].maxIdx = rIdx;
            }
        }
        
        public Node query(int qL, int qR) {
            return query(0, 0, n - 1, qL, qR);
        }
        
        private Node query(int treeIdx, int l, int r, int qL, int qR) {
            if (l == qL && r == qR) {
                return tree[treeIdx];
            }
            
            int lChild = leftChild(treeIdx), rChild = rightChild(treeIdx);
            
            int m = l + (r - l >> 1);
            if (qR <= m) {
                return query(lChild, l, m, qL, qR);
            } else if (qL >= m + 1) {
                return query(rChild, m + 1, r, qL, qR);
            }
            
            Node node = new Node();
            Node left = query(lChild, l, m, qL, m), right = query(rChild, m + 1, r, m + 1, qR);
            if (left.max > right.max) {
                node.max = left.max;
                node.maxIdx = left.maxIdx;
            } else {
                node.max = right.max;
                node.maxIdx = right.maxIdx;
            }
            
            return node;
        }
        
        private int leftChild(int idx) {
            return 2 * idx + 1;
        }
        
        private int rightChild(int idx) {
            return 2 * idx + 2;
        }
    }
    
    private SegmentTree segTree;
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        segTree = new SegmentTree(nums);
        return build(0, nums.length - 1);
    }
    
    private TreeNode build(int l, int r) {
        if (l > r) {
            return null;
        }
        
        SegmentTree.Node node = segTree.query(l, r);
        int max = node.max, maxIdx = node.maxIdx;
        
        TreeNode root = new TreeNode(max);
        root.left = build(l, maxIdx - 1);
        root.right = build(maxIdx + 1, r);
        return root;
    }
}