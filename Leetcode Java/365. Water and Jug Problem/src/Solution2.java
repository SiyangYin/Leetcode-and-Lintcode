import java.util.*;

public class Solution2 {
    class Pair {
        int wat1, wat2;
        
        public Pair(int wat1, int wat2) {
            this.wat1 = wat1;
            this.wat2 = wat2;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return wat1 == pair.wat1 && wat2 == pair.wat2;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(wat1, wat2);
        }
    }
    
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        
        Set<Pair> visited = new HashSet<>();
        visited.add(new Pair(0, 0));
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (Pair next : getNexts(cur, x, y)) {
                if (next.wat1 + next.wat2 == z || next.wat1 == z || next.wat2 == z) {
                    return true;
                }
                
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }
        
        return false;
    }
    
    private Set<Pair> getNexts(Pair cur, int x, int y) {
        Set<Pair> nexts = new HashSet<>();
        nexts.add(new Pair(0, cur.wat2));
        nexts.add(new Pair(x, cur.wat2));
        nexts.add(new Pair(cur.wat1, 0));
        nexts.add(new Pair(cur.wat1, y));
        
        if (x - cur.wat1 <= cur.wat2) {
            nexts.add(new Pair(x, cur.wat2 - (x - cur.wat1)));
        } else {
            nexts.add(new Pair(cur.wat1 + cur.wat2, 0));
        }
        
        if (y - cur.wat2 <= cur.wat1) {
            nexts.add(new Pair(cur.wat1 - (y - cur.wat2), y));
        } else {
            nexts.add(new Pair(0, cur.wat1 + cur.wat2));
        }
        
        return nexts;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().canMeasureWater(3, 5, 4));
    }
}
