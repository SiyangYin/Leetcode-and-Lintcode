import java.util.ArrayDeque;
import java.util.Queue;

public class WebLogger {
    
    private Queue<Integer> queue;
    
    public WebLogger() {
        // do intialization if necessary
        queue = new ArrayDeque<>();
    }
    
    /*
     * @param timestamp: An integer
     * @return: nothing
     */
    public void hit(int timestamp) {
        // write your code here
        queue.offer(timestamp);
    }
    
    /*
     * @param timestamp: An integer
     * @return: An integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // write your code here
        while (!queue.isEmpty() && queue.peek() + 300 < timestamp) {
            queue.poll();
        }
        
        return queue.size();
    }
}