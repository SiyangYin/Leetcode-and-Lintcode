import java.util.*;

public class Solution {
    
    class Tuple {
        int x, y, z;
        
        public Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
        @Override
        public boolean equals(Object o) {
            Tuple triplet = (Tuple) o;
            return x == triplet.x && y == triplet.y && z == triplet.z;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
    
    /**
     * @param N:        the size of space
     * @param barriers: an array of coordinates represents the position of the barrier
     * @return: the minimum number of steps
     */
    public int shortestDistance(int N, int[][] barriers) {
        // Write your code here
        Set<Tuple> barriersSet = new HashSet<>();
        for (int[] barrier : barriers) {
            barriersSet.add(new Tuple(barrier[0], barrier[1], barrier[2]));
        }
        
        Tuple start = new Tuple(0, 0, 0), end = new Tuple(N - 1, N - 1, N - 1);
        if (barriersSet.contains(start) || barriersSet.contains(end)) {
            return -1;
        }
        
        if (N == 1) {
            return 0;
        }
        
        Queue<Tuple> beginQueue = new LinkedList<>(), endQueue = new LinkedList<>();
        Set<Tuple> beginVisited = new HashSet<>(), endVisited = new HashSet<>();
        beginVisited.add(start);
        endVisited.add(end);
        beginQueue.offer(start);
        endQueue.offer(end);
        
        int res = 0;
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            res++;
            int beginSize = beginQueue.size();
            for (int i = 0; i < beginSize; i++) {
                Tuple cur = beginQueue.poll();
                for (Tuple next : getNexts(cur, beginVisited, barriersSet, N)) {
                    if (endVisited.contains(next)) {
                        return res;
                    }
                    
                    beginVisited.add(next);
                    beginQueue.offer(next);
                }
            }
            
            res++;
            int endSize = endQueue.size();
            for (int i = 0; i < endSize; i++) {
                Tuple cur = endQueue.poll();
                for (Tuple next : getNexts(cur, endVisited, barriersSet, N)) {
                    if (beginVisited.contains(next)) {
                        return res;
                    }
                    
                    endVisited.add(next);
                    endQueue.offer(next);
                }
            }
        }
        
        return -1;
    }
    
    private List<Tuple> getNexts(Tuple cur, Set<Tuple> visited, Set<Tuple> barriers, int N) {
        List<Tuple> nexts = new ArrayList<>();
        int[] dx = {1, 0, 0, -1, 0, 0}, dy = {0, 1, 0, 0, -1, 0}, dz = {0, 0, 1, 0, 0, -1};
        for (int i = 0; i < 6; i++) {
            int nextX = cur.x + dx[i], nextY = cur.y + dy[i], nextZ = cur.z + dz[i];
            Tuple next = new Tuple(nextX, nextY, nextZ);
            if (inBound(nextX, nextY, nextZ, N) && !visited.contains(next) && !barriers.contains(next)) {
                nexts.add(next);
                
            }
            
        }
        
        return nexts;
    }
    
    private boolean inBound(int x, int y, int z, int N) {
        return 0 <= x && x < N && 0 <= y && y < N && 0 <= z && z < N;
    }
    
    public static void main(String[] args) {
        int[][] barriers = {{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 1, 0}, {1, 1, 1}, {1, 1, 2}, {1, 2, 1}, {1, 2, 2}};
        System.out.println(new Solution().shortestDistance(3, barriers));
    }
}
