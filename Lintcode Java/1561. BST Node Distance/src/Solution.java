public class Solution {
    
    class BinarySearchTree {
        
        private TreeNode root;
        private int count;
        
        void insert(int val) {
            root = insert(root, val);
        }
        
        private TreeNode insert(TreeNode cur, int val) {
            if (cur == null) {
                cur = new TreeNode(val);
                return cur;
            }
            
            if (val < cur.val) {
                cur.left = insert(cur.left, val);
            } else if (val > cur.val) {
                cur.right = insert(cur.right, val);
            }
            
            return cur;
        }
        
        public int depth(TreeNode cur, int val) {
            if (cur.val == val) {
                return 0;
            }
            
            int res = 0;
            while (cur.val != val) {
                if (val < cur.val) {
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
                
                res++;
            }
            
            return res;
        }
        
        TreeNode lca(int v1, int v2) {
            TreeNode lca = lca(root, v1, v2);
            return count == 2 ? lca : null;
        }
        
        private TreeNode lca(TreeNode cur, int v1, int v2) {
            if (cur == null) {
                return null;
            }
            
            TreeNode left = lca(cur.left, v1, v2), right = lca(cur.right, v1, v2);
            if (cur.val == v1 || cur.val == v2) {
                count++;
                return cur;
            }
            
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                return cur;
            }
        }
    }
    
    /**
     * @param numbers: the given list
     * @param node1:   the given node1
     * @param node2:   the given node2
     * @return: the distance between two nodes
     */
    public int bstDistance(int[] numbers, int node1, int node2) {
        // Write your code here
        BinarySearchTree tree = new BinarySearchTree();
        for (int n : numbers) {
            tree.insert(n);
        }
    
        TreeNode lca = tree.lca(node1, node2);
        if (lca == null) {
            return -1;
        }
        
        return tree.depth(lca, node1) + tree.depth(lca, node2);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().bstDistance(new int[]{2, 1, 3}, 1, 3));
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    
    public TreeNode(int val) {
        this.val = val;
    }
}