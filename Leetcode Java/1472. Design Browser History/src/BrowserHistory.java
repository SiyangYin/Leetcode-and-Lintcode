import java.util.Deque;
import java.util.LinkedList;

class BrowserHistory {
    
    private Deque<String> stackBack, stackForward;
    
    public BrowserHistory(String homepage) {
        stackBack = new LinkedList<>();
        stackBack.push(homepage);
        stackForward = new LinkedList<>();
    }
    
    public void visit(String url) {
        stackBack.push(url);
        stackForward.clear();
    }
    
    public String back(int steps) {
        while (steps > 0 && !stackBack.isEmpty()) {
            stackForward.push(stackBack.pop());
            steps--;
        }
        
        if (stackBack.isEmpty()) {
            stackBack.push(stackForward.pop());
        }
        
        return stackBack.peek();
    }
    
    public String forward(int steps) {
        while (steps > 0 && !stackForward.isEmpty()) {
            stackBack.push(stackForward.pop());
            steps--;
        }
        
        return stackBack.peek();
    }
    
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory("esgriv.com");
        history.visit("cgrt.com");
        history.visit("tip.com");
        System.out.println(history.back(9));
        history.visit("kttzxgh.com");
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */