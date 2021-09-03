import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param quality: an array
     * @param wage:    an array
     * @param K:       an integer
     * @return: the least amount of money needed to form a paid group
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        // Write your code here
        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            list.add(new double[]{quality[i], wage[i]});
        }
        list.sort((w1, w2) -> Double.compare(w1[1] / w1[0], w2[1] / w2[0]));
        
        double res = 1e18, sum = 0.0;
        PriorityQueue<Double> minHeap = new PriorityQueue<>((x, y) -> -Double.compare(x, y));
        for (double[] w : list) {
            sum += w[0];
            minHeap.offer(w[0]);
            if (minHeap.size() > K) {
                sum -= minHeap.poll();
            }
            
            if (minHeap.size() == K) {
                res = Math.min(res, w[1] / w[0] * sum);
            }
        }
        
        return res;
    }
}