public class ReferenceManager {
    public Node node;
    
    public void copyValue(Node obj) {
        // copy value from obj to node
        if (node == null) {
            node = new Node(0);
        }
        node.val = obj.val;
    }
    
    public void copyReference(Node obj) {
        // copy reference from obj to node
        node = obj;
    }
}

class Node {
    public int val;
    
    public Node(int val) {
        this.val = val;
    }
}