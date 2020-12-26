public class Solution {
    /*
     * @param start: start value.
     * @param end: end value.
     * @return: The root of Segment Tree.
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            return root;
        }
        
        root.left = build(start, start + (end - start >> 1));
        root.right = build(start + (end - start >> 1) + 1, end);
        return root;
    }
    
    public static void main(String[] args) {
        SegmentTreeNode root = new Solution().build(1, 4);
        System.out.println(root);
    }
}

class SegmentTreeNode {
    int start, end;
    SegmentTreeNode left, right;
    
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}