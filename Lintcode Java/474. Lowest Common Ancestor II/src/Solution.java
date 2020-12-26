public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        int dA = depth(root, A);
        int dB = depth(root, B);
        
        if (dA > dB) {
            while (dA != dB) {
                A = A.parent;
                dA--;
            }
        } else {
            while (dA != dB) {
                B = B.parent;
                dB--;
            }
        }
        
        while (A != B) {
            A = A.parent;
            B = B.parent;
        }
        
        return A;
    }
    
    private int depth(ParentTreeNode root, ParentTreeNode node) {
        int res = 0;
        while (root != node) {
            node = node.parent;
            res++;
        }
        
        return res;
    }
}

class ParentTreeNode {
    public ParentTreeNode parent, left, right;
}