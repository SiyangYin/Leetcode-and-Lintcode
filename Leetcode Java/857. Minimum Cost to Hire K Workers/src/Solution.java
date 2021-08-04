import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        double ratio;
        int quality;
        
        public Pair(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair((double) wage[i] / quality[i], quality[i]));
        }
        list.sort((p1, p2) -> Double.compare(p1.ratio, p2.ratio));
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> -Integer.compare(x, y));
        double res = 1e18, sum = 0;
        for (Pair pair : list) {
            sum += pair.quality;
            minHeap.offer(pair.quality);
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }
            if (minHeap.size() == k) {
                res = Math.min(res, sum * pair.ratio);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] q = {10, 20, 5}, w = {70, 50, 30};
        int k = 2;
        System.out.println(new Solution().mincostToHireWorkers(q, w, k));
    }
}
