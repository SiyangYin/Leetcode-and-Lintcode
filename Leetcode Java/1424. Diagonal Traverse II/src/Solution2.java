import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;
        
        for (List<Integer> list : nums) {
            count += list.size();
        }
        
        int[] res = new int[count];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        
        int idx = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            res[idx++] = nums.get(cur[0]).get(cur[1]);
            
            if (cur[0] + 1 < nums.size() && cur[1] == 0) {
                queue.offer(new int[]{cur[0] + 1, 0});
            }
            
            if (cur[1] + 1 < nums.get(cur[0]).size()) {
                queue.offer(new int[]{cur[0], cur[1] + 1});
            }
        }
        
        return res;
    }
    
    // public static void main(String[] args) {
    //     List<List<Integer>> nums = new ArrayList<>();
    //     nums.add(Arrays.asList(1, 2, 3, 4, 5));
    //     nums.add(Arrays.asList(6,7));
    //     nums.add(Arrays.asList(8));
    //     nums.add(Arrays.asList(9,10,11));
    //     nums.add(Arrays.asList(12,13,14,15,16));
    //
    //     System.out.println(Arrays.toString(new Solution2().findDiagonalOrder(nums)));
    // }
}
