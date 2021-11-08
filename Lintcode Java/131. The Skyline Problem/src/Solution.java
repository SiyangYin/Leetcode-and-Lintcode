import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    class Pair {
        int pos, h, stat;
        
        public Pair(int pos, int h, int stat) {
            this.pos = pos;
            this.h = h;
            this.stat = stat;
        }
    }
    
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        Pair[] pairs = new Pair[buildings.length << 1];
        for (int i = 0; i < buildings.length; i++) {
            int[] b = buildings[i];
            pairs[i * 2] = new Pair(b[0], b[2], 0);
            pairs[i * 2 + 1] = new Pair(b[1], b[2], 1);
        }
        
        Arrays.sort(pairs, (p1, p2) -> {
            if (p1.pos != p2.pos) {
                return Integer.compare(p1.pos, p2.pos);
            }
            
            if (p1.stat != p2.stat) {
                return Integer.compare(p1.stat, p2.stat);
            }
            
            return Integer.compare(p1.h, p2.h);
        });
        
        TreeMap<Integer, Integer> hMap = new TreeMap<>();
        int preHeight = 0, prePos = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (Pair pair : pairs) {
            if (pair.stat == 0) {
                hMap.put(pair.h, hMap.getOrDefault(pair.h, 0) + 1);
            } else {
                hMap.put(pair.h, hMap.get(pair.h) - 1);
                if (hMap.get(pair.h) == 0) {
                    hMap.remove(pair.h);
                }
            }
            
            int curHeight = hMap.isEmpty() ? 0 : hMap.lastKey();
            if (preHeight != curHeight) {
                if (pair.pos != prePos && preHeight != 0) {
                    res.add(Arrays.asList(prePos, pair.pos, preHeight));
                }
                
                prePos = pair.pos;
                preHeight = curHeight;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] b = {{2, 9, 10}, {2, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(new Solution().buildingOutline(b));
    }
}
