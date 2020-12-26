import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Logger {
    
    class Pair {
        int time;
        String mes;
    
        public Pair(int time, String mes) {
            this.time = time;
            this.mes = mes;
        }
    }
    
    private Queue<Pair> queue;
    private Set<String> set;
    
    /**
     * Initialize your data structure here.
     */
    public Logger() {
        queue = new LinkedList<>();
        set = new HashSet<>();
    }
    
    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        while (!queue.isEmpty()) {
            Pair head = queue.peek();
            if (timestamp - head.time >= 10) {
                queue.poll();
                set.remove(head.mes);
            } else {
                break;
            }
        }
        
        if (!set.contains(message)) {
            queue.offer(new Pair(timestamp, message));
            set.add(message);
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Logger log = new Logger();
        System.out.println(log.shouldPrintMessage(1, "foo"));
        System.out.println(log.shouldPrintMessage(4, "foo"));
        System.out.println(log.shouldPrintMessage(10, "foo"));
        System.out.println(log.shouldPrintMessage(11, "foo"));
    }
}
