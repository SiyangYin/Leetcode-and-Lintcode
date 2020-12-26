import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    
    class Pair {
        int idx, height, flag;
    
        public Pair(int idx, int height, int flag) {
            this.idx = idx;
            this.height = height;
            this.flag = flag;
        }
    }
    
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
    
        List<Pair> list = new ArrayList<>();
        for (int[] building : buildings) {
            list.add(new Pair(building[0], building[2], 1));
            list.add(new Pair(building[1], building[2], 0));
        }
        
        list.sort((p1, p2) -> p1.idx != p2.idx ? Integer.compare(p1.idx, p2.idx) : Integer.compare(p1.flag, p2.flag));
        
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();
        
        return res;
    }
}
