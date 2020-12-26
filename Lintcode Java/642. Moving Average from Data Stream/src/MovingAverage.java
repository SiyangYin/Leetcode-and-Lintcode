import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {
    
    Queue<Integer> queue;
    double sum;
    int size;
    
    /*
     * @param size: An integer
     */
    public MovingAverage(int size) {
        // do intialization if necessary
        queue = new ArrayDeque<>();
        this.size = size;
    }
    
    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
        queue.offer(val);
        sum += val;
        if (queue.size() > size) {
            sum -= queue.poll();
        }
        
        return sum / queue.size();
    }
}