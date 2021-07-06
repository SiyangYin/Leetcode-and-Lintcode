public class Solution {
    /**
     * @param tasks: the given char array representing tasks CPU need to do
     * @param n:     the non-negative cooling interval
     * @return: the least number of intervals the CPU will take to finish all the given tasks
     */
    public int leastInterval(char[] tasks, int n) {
        // write your code here
        int[] count = new int[26];
        int max = 0;
        for (char task : tasks) {
            count[task - 'A']++;
            max = Math.max(max, count[task - 'A']);
        }
        
        int res = (max - 1) * (n + 1);
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                res++;
            }
        }
        
        return Math.max(res, tasks.length);
    }
    
    public static void main(String[] args) {
        char[] chs = "AAABBBCCCDDD".toCharArray();
        System.out.println(new Solution().leastInterval(chs, 2));
    }
}
