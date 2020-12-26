import java.util.PriorityQueue;

public class Solution {
    
    class Pair implements Comparable<Pair> {
        private char ch;
        private int fund;
        
        public Pair(char ch, int fund) {
            this.ch = ch;
            this.fund = fund;
        }
        
        @Override
        public int compareTo(Pair p) {
            if (fund != p.fund) {
                return Integer.compare(fund, p.fund);
            } else {
                return Character.compare(ch, p.ch);
            }
        }
    }
    
    /**
     * @param funds: The investment each time
     * @param a:     The initial funds of A
     * @param b:     The initial funds of B
     * @param c:     The initial funds of C
     * @return: The final funds
     */
    public int[] getAns(int[] funds, int a, int b, int c) {
        // Write your code here
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair('A', a));
        minHeap.offer(new Pair('B', b));
        minHeap.offer(new Pair('C', c));
    
        for (int fund : funds) {
            Pair cur = minHeap.poll();
            cur.fund += fund;
            minHeap.offer(cur);
        }
        
        int[] res = new int[3];
        while (!minHeap.isEmpty()) {
            Pair cur = minHeap.poll();
            res[cur.ch - 'A'] = cur.fund;
        }
        
        return res;
    }
}
