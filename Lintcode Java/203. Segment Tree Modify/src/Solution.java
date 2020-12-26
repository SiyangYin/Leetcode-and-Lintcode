public class Solution {
    /**
     * @param root: The root of segment tree.
     * @param index: index.
     * @param value: value
     * @return: nothing
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        int mid = root.start + (root.end - root.start >> 1);
        if (root.start == root.end && root.start == index) {
            root.max = value;
            return;
        }
        
        if (index <= mid) {
            modify(root.left, index, value);
        } else if (index > mid) {
            modify(root.right, index, value);
        }
        
        root.max = Math.max(root.left.max, root.right.max);
    }
    
    public static void main(String[] args) {
        SegmentTreeNode root = new SegmentTreeNode(1, 4, 3);
        root.left = new SegmentTreeNode(1, 2, 2);
        root.left.left = new SegmentTreeNode(1, 1, 2);
        root.left.right = new SegmentTreeNode(2, 2, 1);
        root.right = new SegmentTreeNode(3, 4, 3);
        root.right.left = new SegmentTreeNode(3, 3, 0);
        root.right.right = new SegmentTreeNode(4, 4, 3);
    
        new Solution().modify(root, 4, 0);
    
        System.out.println();
    }
}

class SegmentTreeNode {
    int start, end, max;
    SegmentTreeNode left, right;
    
    public SegmentTreeNode(int start, int end, int max) {
        this.start = start;
        this.end = end;
        this.max = max;
    }
}