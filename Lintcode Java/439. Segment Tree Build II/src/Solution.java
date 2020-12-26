public class Solution {
    /**
     * @param A: a list of integer
     * @return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        return dfs(A, 0, A.length - 1);
    }
    
    private SegmentTreeNode dfs(int[] A, int i, int j) {
        if (i == j) {
            return new SegmentTreeNode(i, j, A[i]);
        }
    
        SegmentTreeNode left = dfs(A, i, i + (j - i >> 1));
        SegmentTreeNode right = dfs(A, i + (j - i >> 1) + 1, j);
        SegmentTreeNode root = new SegmentTreeNode(i, j, Math.max(left.max, right.max));
        root.left = left;
        root.right = right;
        return root;
    }
    
    public static void main(String[] args) {
        SegmentTreeNode root = new Solution().build(new int[]{3, 2, 1, 4});
        System.out.println(root);
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
