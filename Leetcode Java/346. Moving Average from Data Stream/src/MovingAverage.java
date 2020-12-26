import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    
    double sum;
    int capacity;
    Queue<Double> queue;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        capacity = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        queue.offer((double) (val));
        
        while (queue.size() > capacity) {
            sum -= queue.poll();
        }
        
        return sum / queue.size();
    }
}
