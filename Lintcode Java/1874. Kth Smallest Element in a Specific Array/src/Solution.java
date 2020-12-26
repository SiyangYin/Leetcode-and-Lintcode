import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int x, y, val;
    
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    
    /**
     * @param arr: an array of integers
     * @param k: an integer
     * @return: the Kth smallest element in a specific array
     */
    public int kthSmallest(int[][] arr, int k) {
        // write your code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.val, p2.val));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 0) {
                minHeap.offer(new Pair(i, 0, arr[i][0]));
            }
        }
    
        for (int i = 1; i <= k - 1; i++) {
            Pair cur = minHeap.poll();
            if (cur.y + 1 < arr[cur.x].length) {
                minHeap.offer(new Pair(cur.x, cur.y + 1, arr[cur.x][cur.y + 1]));
            }
        }
        
        return minHeap.peek().val;
    }
}
