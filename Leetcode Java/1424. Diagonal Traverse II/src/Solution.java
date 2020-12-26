import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Pair {
        int x,  y;
    
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new Pair(i, j));
            }
        }
        
        list.sort((o1, o2) -> {
            int s1 = o1.x + o1.y, s2 = o2.x + o2.y;
            if (s1 != s2) {
                return Integer.compare(s1, s2);
            }
            
            return -Integer.compare(o1.x, o2.x);
        });
        
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            Pair pair = list.get(i);
            res[i] = nums.get(pair.x).get(pair.y);
        }
        
        return res;
    }
}
