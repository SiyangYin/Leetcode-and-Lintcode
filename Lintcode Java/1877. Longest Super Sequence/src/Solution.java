import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    /**
     * @param nums: the input array
     * @return: return the longest super sequence
     */
    public int[] longestSuperSequence(int[] nums) {
        // write your code here
        int[] count = new int[3001];
        for (int num : nums) {
            count[num]++;
        }
        
        int maxCount = 0, maxCountNum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((x, y) -> Integer.compare(count[x], count[y]));
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                minHeap.offer(i);
            }
            
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxCountNum = i;
            }
        }
        
        if (maxCount == 1) {
            return nums;
        }
        
        int maxLen = 0, mostCount = 0;
        while (!minHeap.isEmpty()) {
            int cur = minHeap.poll();
            if ((count[cur] - 1) * (minHeap.size() + 1) + 1 > maxLen) {
                maxLen = (count[cur] - 1) * (minHeap.size() + 1) + 1;
                mostCount = count[cur] - 1;
            }
            
            if (count[cur] * (minHeap.size() + 1) + 1 > maxLen && maxCount > count[cur]) {
                maxLen = count[cur] * (minHeap.size() + 1) + 1;
                mostCount = count[cur];
            }
        }
        
        int[] res = new int[maxLen], resCount = new int[3001];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxCountNum && resCount[maxCountNum] < mostCount + 1) {
                res[idx++] = nums[i];
                resCount[nums[i]]++;
            } else if (nums[i] != maxCountNum && count[nums[i]] >= mostCount && resCount[nums[i]] < mostCount) {
                res[idx++] = nums[i];
                resCount[nums[i]]++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[] nums = {1,1,1,1};
        // int[] nums = {1, 1, 1, 3, 2, 2, 2, 3};
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(new Solution().longestSuperSequence(nums)));
    }
}
