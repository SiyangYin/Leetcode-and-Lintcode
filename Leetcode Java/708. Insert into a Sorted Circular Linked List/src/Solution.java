public class Solution {
    public Node insert(Node node, int insertVal) {
        // write your code here
        Node xNode  = new Node(insertVal);
        if (node == null) {
            xNode.next = xNode;
            return xNode;
        }
        
        Node prev = node;
        do {
            if (prev.val <= insertVal && insertVal <= prev.next.val) {
                break;
            }
            prev = prev.next;
        } while (prev != node);
        
        if (prev.val <= insertVal && insertVal <= prev.next.val) {
            return insertNode(prev, xNode);
        }
        
        do {
            if (prev.val > prev.next.val) {
                break;
            }
            prev = prev.next;
        } while (prev != node);
        
        return insertNode(prev, xNode);
    }
    
    private Node insertNode(Node prev, Node insert) {
        insert.next = prev.next;
        prev.next = insert;
        return insert;
    }
}

class Node {
    int val;
    Node next;
    
    Node() {
    }
    
    Node(int val) {
        this.val = val;
    }
    
    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
