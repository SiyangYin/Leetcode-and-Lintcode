import java.util.Arrays;

public class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (t1, t2) -> Integer.compare(t1[1] - t1[0], t2[1] - t2[0]));
        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            res = Math.max(res + task[0], task[1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {4, 8}};
        System.out.println(new Solution().minimumEffort(tasks));
    }
}
