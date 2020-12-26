public class BrowserHistory2 {
    
    class ListNode {
        String val;
        ListNode prev, next;
        
        public ListNode(String val) {
            this.val = val;
        }
    }
    
    private ListNode cur;
    
    public BrowserHistory2(String homepage) {
        cur = new ListNode(homepage);
    }
    
    public void visit(String url) {
        cur.next = new ListNode(url);
        cur.next.prev = cur;
        cur = cur.next;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (cur.prev != null) {
                cur = cur.prev;
            } else {
                break;
            }
        }
        
        return cur.val;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (cur.next != null) {
                cur = cur.next;
            } else {
                break;
            }
        }
        
        return cur.val;
    }
    
    public static void main(String[] args) {
        BrowserHistory2 history2 = new BrowserHistory2("leetcode");
        history2.visit("google");
        history2.visit("facebook");
        history2.visit("youtube");
    
        System.out.println(history2.back(1));
        System.out.println(history2.back(1));
        System.out.println(history2.forward(1));
    }
}
