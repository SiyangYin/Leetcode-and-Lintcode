import java.util.*;

public class Solution2 {
    
    class Tuple {
        int[] w;
        
        public Tuple(int[] w) {
            this.w = w;
        }
        
        @Override
        public boolean equals(Object o) {
            Tuple tuple = (Tuple) o;
            return Arrays.equals(w, tuple.w);
        }
        
        @Override
        public int hashCode() {
            return Arrays.hashCode(w);
        }
    }
    
    /**
     * @param s: the volume of cola
     * @param n: the volume of the first cup
     * @param m: the volume of the second cup
     * @return: the minimum number of times to be inverted
     */
    public int getMinTimes(int s, int n, int m) {
        // Write your code here
        if (s % 2 != 0) {
            return -1;
        }
        
        Tuple start = new Tuple(new int[]{s, 0, 0});
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(start);
        Set<Tuple> visited = new HashSet<>();
        visited.add(start);
        
        int step = 0;
        int[] r = {s, n, m};
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tuple cur = queue.poll();
                Set<Tuple> nexts = getNexts(cur, r, visited);
                for (Tuple next : nexts) {
                    if (check(next, s)) {
                        return step;
                    }
                    
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        
        return -1;
    }
    
    private Set<Tuple> getNexts(Tuple cur, int[] r, Set<Tuple> visited) {
        Set<Tuple> nexts = new HashSet<>();
        int[] w = cur.w;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                
                int from = w[i], to = w[j];
                if (from == 0 || to == r[j]) {
                    continue;
                }
                
                if (from >= r[j] - to) {
                    from -= r[j] - to;
                    to = r[j];
                } else {
                    to += from;
                    from = 0;
                }
                
                int[] ww = new int[3];
                ww[i] = from;
                ww[j] = to;
                ww[i ^ j ^ 1 ^ 2] = w[i ^ j ^ 1 ^ 2];
                
                Tuple next = new Tuple(ww);
                if (!visited.contains(next)) {
                    nexts.add(next);
                }
            }
        }
        
        return nexts;
    }
    
    private boolean check(Tuple tuple, int s) {
        int[] w = Arrays.copyOf(tuple.w, 3);
        Arrays.sort(w);
        return w[1] == w[2] && w[2] == s / 2;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().getMinTimes(4, 1, 3));
    }
}
