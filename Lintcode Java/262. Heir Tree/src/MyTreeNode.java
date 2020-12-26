import java.util.ArrayList;
import java.util.List;

public class MyTreeNode {
    
    private int val;
    private boolean deleted;
    public List<MyTreeNode> children;
    
    /**
     * @param val: the val of the node
     * @return: a MyTreeNode Object
     */
    MyTreeNode(int val) {
        // write your code here
        this.val = val;
        children = new ArrayList<>();
    }
    
    /**
     * @param root: the root treenode
     * @return: get the traverse of the treenode
     */
    public ArrayList<Integer> traverse(MyTreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        if (!root.deleted) {
            res.add(root.val);
        }
        for (MyTreeNode child : root.children) {
            res.addAll(traverse(child));
        }
        
        return res;
    }
    
    /**
     * @param root:  the node where added
     * @param value: the added node's value
     * @return: add a node, return the node
     */
    public MyTreeNode addNode(MyTreeNode root, int value) {
        // write your code here
        MyTreeNode child = new MyTreeNode(value);
        root.children.add(child);
        return child;
    }
    
    /**
     * @param root: the deleted node
     * @return: nothing
     */
    public void deleteNode(MyTreeNode root) {
        // write your code here
        root.deleted = true;
    }
}