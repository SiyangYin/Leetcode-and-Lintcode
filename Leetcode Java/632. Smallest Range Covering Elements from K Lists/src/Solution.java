import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1[0], p2[0]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            maxHeap.offer(new int[]{val, i, 0});
            max = Math.max(max, val);
        }
        
        int[] res = null;
        while (true) {
            int[] top = maxHeap.poll();
            int l = top[0], r = max;
            if (res == null || res[1] - res[0] > r - l) {
                res = new int[]{l, r};
            }
            
            int row = top[1], idx = top[2];
            if (idx + 1 < nums.get(row).size()) {
                int val = nums.get(row).get(idx + 1);
                maxHeap.offer(new int[]{val, row, idx + 1});
                max = Math.max(max, val);
            } else {
                break;
            }
        }
        
        return res;
    }
}
