import java.util.*;

public class Solution {
    
    class Pair {
        int xy, idx;
    
        public Pair(int xy, int idx) {
            this.xy = xy;
            this.idx = idx;
        }
    }
    
    /**
     * @param x: an array of integers, the x coordinates of each city[i]
     * @param y: an array of integers, the y coordinates of each city[i]
     * @param c: an array of strings that represent the names of each city[i]
     * @param q: an array of strings that represent the names of query locations
     * @return: the closest city for each query
     */
    public String[] NearestNeighbor(int[] x, int[] y, String[] c, String[] q) {
        // write your code here
        Map<Integer, List<Pair>> xmap = new HashMap<>(), ymap = new HashMap<>();
        Map<String, Integer> cityToIdx = new HashMap<>();
        for (int i = 0; i < c.length; i++) {
            xmap.putIfAbsent(x[i], new ArrayList<>());
            xmap.get(x[i]).add(new Pair(y[i], i));
            ymap.putIfAbsent(y[i], new ArrayList<>());
            ymap.get(y[i]).add(new Pair(x[i], i));
            
            cityToIdx.put(c[i], i);
        }
    
        String[] res = new String[q.length];
        for (int i = 0; i < q.length; i++) {
            int idx = cityToIdx.get(q[i]);
            List<Pair> ylist = xmap.get(x[idx]);
    
            int dis = Integer.MAX_VALUE;
            String name = "";
            for (Pair city : ylist) {
                if (city.idx == idx) {
                    continue;
                }
                
                if (Math.abs(city.xy - y[idx]) < dis) {
                    dis = Math.abs(city.xy - y[idx]);
                    name = c[city.idx];
                } else if (Math.abs(city.xy - y[idx]) == dis && c[city.idx].compareTo(name) < 0) {
                    name = c[city.idx];
                }
            }
    
            List<Pair> xlist = ymap.get(y[idx]);
            for (Pair city : xlist) {
                if (city.idx == idx) {
                    continue;
                }
                
                if (Math.abs(city.xy - y[idx]) < dis) {
                    dis = Math.abs(city.xy - y[idx]);
                    name = c[city.idx];
                } else if (Math.abs(city.xy - y[idx]) == dis && c[city.idx].compareTo(name) < 0) {
                    name = c[city.idx];
                }
            }
            
            if (name.isEmpty()) {
                res[i] = "NONE";
            } else {
                res[i] = name;
            }
        }
    
        return res;
    }
    
    public static void main(String[] args) {
        int[] x = {3, 2, 1}, y = {3, 2, 3};
        String[] c = {"c1", "c2", "c3"}, q = {"c1", "c2", "c3"};
        System.out.println(Arrays.toString(new Solution().NearestNeighbor(x, y, c, q)));
    }
}
