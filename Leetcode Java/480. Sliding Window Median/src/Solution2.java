import java.util.Arrays;
import java.util.TreeSet;

public class Solution2 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        TreeSet<Integer> minSet = new TreeSet<>((i1, i2) -> nums[i1] < nums[i2] ? -1 : 1);
        TreeSet<Integer> maxSet = new TreeSet<>((i1, i2) -> nums[i1] > nums[i2] ? -1 : 1);
        
        double[] res = new double[nums.length - k + 1];
    
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                addNum(nums, i, minSet, maxSet);
            } else {
                res[i - k] = findMedian(nums, minSet, maxSet);
                removeIndex(minSet, maxSet, i - k);
                addNum(nums, i, minSet, maxSet);
            }
        }
    
        res[res.length - 1] = findMedian(nums, minSet, maxSet);
        
        return res;
    }
    
    private void addNum(int[] nums, int i, TreeSet<Integer> minSet, TreeSet<Integer> maxSet) {
        if (!minSet.isEmpty() && nums[i] > nums[minSet.first()]) {
            minSet.add(i);
        } else {
            maxSet.add(i);
        }
        
        if (minSet.size() > maxSet.size() + 1) {
            maxSet.add(minSet.pollFirst());
        } else if (maxSet.size() > minSet.size() + 1) {
            minSet.add(maxSet.pollFirst());
        }
    }
    
    private void removeIndex(TreeSet<Integer> minSet, TreeSet<Integer> maxSet, int i) {
        minSet.removeIf(integer -> integer == i);
        maxSet.removeIf(integer -> integer == i);
    }
    
    private double findMedian(int[] nums, TreeSet<Integer> minSet, TreeSet<Integer> maxSet) {
        if (minSet.size() > maxSet.size()) {
            return nums[minSet.first()];
        } else if (minSet.size() < maxSet.size()) {
            return nums[maxSet.first()];
        } else {
            return ((double) nums[minSet.first()] + (double) nums[maxSet.first()]) / 2.0;
        }
    }
    
    public static void main(String[] args) {
        // int[] nums = {2147483647, 2147483647};
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new Solution2().medianSlidingWindow(nums, 3)));
    }
}
