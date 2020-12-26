import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> nums[i1] < nums[i2] ? -1 : 1);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> nums[i1] > nums[i2] ? -1 : 1);
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                addNum(nums, i, minHeap, maxHeap);
            } else {
                res[i - k] = findMedian(nums, minHeap, maxHeap);
                removeIndex(minHeap, maxHeap, i - k);
                addNum(nums, i, minHeap, maxHeap);
            }
        }
        
        res[res.length - 1] = findMedian(nums, minHeap, maxHeap);
        
        return res;
    }
    
    private void addNum(int[] nums, int i, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (!minHeap.isEmpty() && nums[i] > nums[minHeap.peek()]) {
            minHeap.offer(i);
        } else {
            maxHeap.offer(i);
        }
        
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    private void removeIndex(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int i) {
        if (!minHeap.remove(i)) {
            maxHeap.remove(i);
        }
    }
    
    private double findMedian(int[] nums, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (minHeap.size() > maxHeap.size()) {
            return nums[minHeap.peek()];
        } else if (minHeap.size() < maxHeap.size()) {
            return nums[maxHeap.peek()];
        } else {
            return (nums[minHeap.peek()] + nums[maxHeap.peek()]) / 2.0;
        }
    }
    
    
    public static void main(String[] args) {
        int[] nums = {2147483647, 2147483647};
        System.out.println(Arrays.toString(new Solution().medianSlidingWindow(nums, 3)));
    }
}
