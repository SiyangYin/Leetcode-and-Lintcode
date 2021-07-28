public class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        int[] posPre = new int[n + 1], posPost = new int[n + 1];
        for (int i = 0; i < n; i++) {
            posPre[preorder[i]] = i;
            posPost[postorder[i]] = i;
        }
        
        return dfs(preorder, 0, n - 1, postorder, 0, n - 1, posPre, posPost);
    }
    
    private TreeNode dfs(int[] pre, int l1, int r1, int[] post, int l2, int r2, int[] posPre, int[] posPost) {
        if (l1 > r1) {
            return null;
        }
        
        if (l1 == r1) {
            return new TreeNode(pre[l1]);
        }
        
        TreeNode root = new TreeNode(pre[l1]);
        int leftRoot = pre[l1 + 1], rightRoot = post[r2 - 1];
        root.left = dfs(pre, l1 + 1, posPre[rightRoot] - 1, post, l2, posPost[leftRoot], posPre, posPost);
        root.right = dfs(pre, posPre[rightRoot], r1, post, posPost[leftRoot] + 1, r2 - 1, posPre, posPost);
        return root;
    }
    
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7}, post = {4, 5, 2, 6, 7, 3, 1};
        // int[] pre = {1, 2, 4, 3, 5, 6}, post = {4, 2, 5, 6, 3, 1};
        TreeNode root = new Solution().constructFromPrePost(pre, post);
        
        System.out.println();
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}