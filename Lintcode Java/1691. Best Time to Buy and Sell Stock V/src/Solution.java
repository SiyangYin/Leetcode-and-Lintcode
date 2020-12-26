import java.util.PriorityQueue;

public class Solution {
    /**
     * @param a: the array a
     * @return: return the maximum profit
     */
    public int getAns(int[] a) {
        // write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int res = 0;
        for (int price : a) {
            // 如果k比之前遇到过的最低价高
            if (minHeap.size() > 0 && price > minHeap.peek()) {
                // 收益就是当前k - 遇到过的最低价
                res += price - minHeap.poll();
                // 看后面
                minHeap.offer(price);
            }
            
            // 同时将当前值压入队列
            // 看看后面有没有价格与price配对赚钱
            minHeap.offer(price);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        //                                                 1
        //                                   res              1
        // System.out.println(new Solution().getAns(new int[]{1, 2, 10, 3, 9, 11}));
        System.out.println(new Solution().getAns(new int[]{1, 2, 10}));
    }
}
