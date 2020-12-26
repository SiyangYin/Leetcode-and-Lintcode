import java.util.PriorityQueue;

public class Solution {
    public String minimizeError(String[] prices, int target) {
        PriorityQueue<Double> minHeap = new PriorityQueue<>((d1, d2) -> Double.compare(Math.ceil(d1) - d1, Math.ceil(d2) - d2));
        int sum = 0;
        for (String price : prices) {
            double val = Double.parseDouble(price);
            minHeap.offer(val);
            
            sum += Math.floor(val);
        }
        
        if (target - sum > prices.length || sum > target) {
            return "-1";
        }
        
        double res = 0;
        int count = target - sum;
        while (!minHeap.isEmpty()) {
            if (count == 0) {
                break;
            }
            
            count--;
            double cur = minHeap.poll();
            res += Math.ceil(cur) - cur;
        }
        
        return String.valueOf(res);
    }
    
    public static void main(String[] args) {
        String[] pri = {"0.700", "2.800", "4.900"};
        int target = 8;
        System.out.println(new Solution().minimizeError(pri, target));
    }
}
