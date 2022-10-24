import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class BrowserHistory3 {
    private List<String> list;
    private int p;
    public BrowserHistory3(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
        p = 0;
    }

    public void visit(String url) {
        while (list.size() - 1 > p) {
            list.remove(list.size() - 1);
        }
        list.add(url);
        p++;
    }

    public String back(int steps) {
        if (steps < p) {
            p -= steps;
        }
        else {
            p = 0;
        }
        return list.get(p);
    }

    public String forward(int steps) {
        if (p + steps < list.size()) {
            p += steps;
        }
        else {
            p = list.size() - 1;
        }
        return list.get(p);
    }
    
    public static void main(String[] args) {
        BrowserHistory3 history = new BrowserHistory3("esgriv.com");
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