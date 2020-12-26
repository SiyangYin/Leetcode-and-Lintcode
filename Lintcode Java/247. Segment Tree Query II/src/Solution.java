public class Solution {
    /*
     * @param root: The root of segment tree.
     * @param start: start value.
     * @param end: end value.
     * @return: The count number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (root == null || end < root.start || start > root.end) {
            return 0;
        }
        
        if (start <= root.start && end >= root.end) {
            return root.count;
        }
        
        int mid = root.start + (root.end - root.start >> 1);
        if (end <= mid) {
            return query(root.left, start, end);
        }
        
        if (mid < start) {
            return query(root.right, start, end);
        }
        
        return query(root.left, start, mid) + query(root.right, mid + 1, end);
    }
}

class SegmentTreeNode {
    int start, end, count;
    SegmentTreeNode left, right;
    
    public SegmentTreeNode(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
    }
}
