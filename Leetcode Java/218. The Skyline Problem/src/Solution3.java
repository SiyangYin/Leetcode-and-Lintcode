import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution3 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((i1, i2) -> i1[0] - i2[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
        List<List<Integer>> res = new ArrayList<>();
        for (int[] i : buildings) {
            minHeap.offer(new int[]{i[0], i[2], 1});
            minHeap.offer(new int[]{i[1], i[2], -1});
        }
        while (!minHeap.isEmpty()) {
            int[] i = minHeap.poll();
            if (i[2] == 1) {
                if (maxHeap.isEmpty() || i[1] > maxHeap.peek()) {
                    if (res.size() > 0 && res.get(res.size() - 1).get(0).equals(i[0])) {
                        res.remove(res.size() - 1);
                    }
                    if (res.size() == 0 || !res.get(res.size() - 1).get(1).equals(i[1])) {
                        res.add(Arrays.asList(i[0], i[1]));
                    }
                }
                maxHeap.offer(i[1]);
            }
            else if (i[2] == -1) {
                if (i[1] == maxHeap.peek()) {
                    maxHeap.poll();
                    if (maxHeap.isEmpty()) {
                        if (res.size() > 0 && res.get(res.size() - 1).get(0).equals(i[0])) {
                            res.remove(res.size() - 1);
                        }
                        res.add(Arrays.asList(i[0], 0));
                    }
                    else {
                        if (res.size() > 0 && res.get(res.size() - 1).get(0).equals(i[0])) {
                            res.remove(res.size() - 1);
                        }
                        if (res.size() == 0 || !res.get(res.size() - 1).get(1).equals(maxHeap.peek())) {
                            res.add(Arrays.asList(i[0], maxHeap.peek()));
                        }
                    }
                }
                else {
                    maxHeap.remove(i[1]);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[][] b = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new Solution3().getSkyline(b));
    }
}