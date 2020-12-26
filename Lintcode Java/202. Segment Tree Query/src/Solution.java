public class Solution {
    /**
     * @param root:  The root of segment tree.
     * @param start: start value.
     * @param end:   end value.
     * @return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start == root.start && root.end == end) {
            return root.max;
        }
        
        int mid = root.start + (root.end - root.start >> 1);
        
        if (end <= mid) {
            return query(root.left, start, end);
        }
        if (start >= mid + 1) {
            return query(root.right, start, end);
        }
        
        int left = query(root.left, start, mid), right = query(root.right, mid + 1, end);
        
        return Math.max(left, right);
    }
    
    public static void main(String[] args) {
        SegmentTreeNode root = new SegmentTreeNode(0, 3, 4);
        root.left = new SegmentTreeNode(0, 1, 4);
        root.left.left = new SegmentTreeNode(0, 0, 1);
        root.left.right = new SegmentTreeNode(1, 1, 4);
        root.right = new SegmentTreeNode(2, 3, 3);
        root.right.left = new SegmentTreeNode(2, 2, 2);
        root.right.right = new SegmentTreeNode(3, 3, 3);
        
        System.out.println(new Solution().query(root, 0, 0));
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
