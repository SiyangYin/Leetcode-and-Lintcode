import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Solution {
    
    class Pair {
        int x, y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public boolean isPathCrossing(String path) {
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(0, 0));
        
        int[] d = {1, 0, -1, 0, 1};
        Map<Character, Integer> map = Map.of('N', 3, 'S', 1, 'E', 0, 'W', 2);
        
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            int idx = map.get(path.charAt(i));
            x += d[idx];
            y += d[idx + 1];
            Pair next = new Pair(x, y);
            if (set.contains(next)) {
                return true;
            }
            
            set.add(next);
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isPathCrossing("NNS"));
    }
}
