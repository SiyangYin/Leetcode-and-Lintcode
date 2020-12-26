import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
        for (int[] item : items) {
            map.putIfAbsent(item[0], new PriorityQueue<>());
            PriorityQueue<Integer> minHeap = map.get(item[0]);
            if (minHeap.size() < 5) {
                minHeap.offer(item[1]);
            } else {
                if (item[1] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(item[1]);
                }
            }
        }
     
        int[][] res = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            res[idx][0] = entry.getKey();
            int sum = 0;
            for (int score : entry.getValue()) {
                sum += score;
            }
            
            res[idx][1] = sum / 5;
            idx++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        new Solution().highFive(new int[2][2]);
    }
}
