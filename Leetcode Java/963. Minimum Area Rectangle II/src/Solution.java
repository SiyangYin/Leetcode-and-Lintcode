import java.util.*;

public class Solution {
    
    class Edge {
        long x1, y1, x2, y2;
        
        public Edge(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        
        double area(Edge e) {
            long x = e.x1, y = e.y1;
            if ((y - y1) * (x - x2) == (y - y2) * (x - x1)) {
                return 0;
            }
            
            double a = Math.sqrt(pow2(x - x1) + pow2(y - y1));
            double b = Math.sqrt(pow2(x - x2) + pow2(y - y2));
            return a * b;
        }
        
        double pow2(double x) {
            return x * x;
        }
    }
    
    class ID {
        long midx, midy, dist;
        
        public ID(int[] p1, int[] p2) {
            long[] A = calculate(p1[0], p1[1], p2[0], p2[1]);
            midx = A[0];
            midy = A[1];
            dist = A[2];
        }
        
        @Override
        public boolean equals(Object o) {
            ID id = (ID) o;
            return midx == id.midx && midy == id.midy && dist == id.dist;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(midx, midy, dist);
        }
        
        long[] calculate(long x1, long y1, long x2, long y2) {
            return new long[]{x1 + x2 >> 1, y1 + y2 >> 1, pow2(x1 - x2) + pow2(y1 - y2)};
        }
        
        long pow2(long x) {
            return x * x;
        }
    }
    
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        for (int[] p : points) {
            p[0] <<= 1;
            p[1] <<= 1;
        }
        
        Map<ID, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i], p2 = points[j];
                ID id = new ID(p1, p2);
                map.putIfAbsent(id, new ArrayList<>());
                map.get(id).add(new Edge(p1[0], p1[1], p2[0], p2[1]));
            }
        }
        
        double res = 1e19;
        for (Map.Entry<ID, List<Edge>> entry : map.entrySet()) {
            List<Edge> list = entry.getValue();
            if (list.size() == 1) {
                continue;
            }
            
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    double area = list.get(i).area(list.get(j));
                    if (area > 0) {
                        res = Math.min(res, area);
                    }
                }
            }
        }
        
        return res == 1e19 ? 0 : res / 4.0;
    }
    
    public static void main(String[] args) {
        int[][] p = {{2, 1}, {0, 0}, {0, 3}, {1, 3}, {3, 2}, {1, 0}, {2, 3}, {0, 2}};
        System.out.println(new Solution().minAreaFreeRect(p));
    }
}
