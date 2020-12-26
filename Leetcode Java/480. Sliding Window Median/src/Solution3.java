import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution3 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i1 > i2 ? -1 : 1);
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                addNum(nums[i], minHeap, maxHeap);
            } else {
                res[i - k] = findMedian(minHeap, maxHeap);
                remove(minHeap, maxHeap, nums[i - k]);
                addNum(nums[i], minHeap, maxHeap);
            }
        }
        
        res[res.length - 1] = findMedian(minHeap, maxHeap);
        
        return res;
    }
    
    private void addNum(int num, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (!minHeap.isEmpty() && num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
    }
    
    private void remove(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int num) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
    }
    
    private double findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        while (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        }
        while (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else {
            return ((double) minHeap.peek() + (double) maxHeap.peek()) / 2.0;
        }
    }
    
    public static void main(String[] args) {
        // int[] nums = {2147483647, 2147483647};
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new Solution3().medianSlidingWindow(nums, 3)));
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
    }
}
