import java.util.Arrays;
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
     * @param arrays: a list of array
     * @param k:      An integer
     * @return: an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> -Integer.compare(p1.val, p2.val));
        for (int i = 0; i < arrays.length; i++) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                maxHeap.offer(new Pair(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]));
            }
        }
        
        for (int i = 0; i < k - 1; i++) {
            Pair cur = maxHeap.poll();
            if (cur.y >= 1) {
                maxHeap.offer(new Pair(cur.x, cur.y - 1, arrays[cur.x][cur.y - 1]));
            }
        }
        
        return maxHeap.peek().val;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{}, {}, {1}, {1, 2, 3, 4}, {11, 10, 9, 8, 7}};
        System.out.println(new Solution().KthInArrays(arr, 5));
    }
}
