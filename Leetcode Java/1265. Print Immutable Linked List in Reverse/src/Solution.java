public class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }
 
        printLinkedListInReverse(head.getNext());
 
        head.printValue();
    }
}

interface ImmutableListNode {
    void printValue(); // print the value of this node.
    
    ImmutableListNode getNext(); // return the next node.
}
