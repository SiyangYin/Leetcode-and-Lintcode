import java.util.Arrays;

public class Solution2 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
    
        Arrays.sort(count);
        reverse(count);
        
        int idle = (count[0] - 1) * n;
        for (int i = 1; i < count.length; i++) {
            idle -= Math.min(count[0] - 1, count[i]);
        }
        
        idle = Math.max(0, idle);
        return idle + tasks.length;
    }
    
    private void reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    public static void main(String[] args) {
        char[] t = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        // char[] t = {'A', 'A', 'A', 'B', 'B', 'B'};
        // System.out.println(t.length);
        
        System.out.println(new Solution().leastInterval(t, 2));
    }
}
