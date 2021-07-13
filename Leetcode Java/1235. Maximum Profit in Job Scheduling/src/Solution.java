import java.util.Arrays;

public class Solution {
    
    class Job {
        int st, ed, profit;
        
        public Job(int st, int ed, int profit) {
            this.st = st;
            this.ed = ed;
            this.profit = profit;
        }
    }
    
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        
        Arrays.sort(jobs, (j1, j2) -> Integer.compare(j1.ed, j2.ed));
        
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            int idx = binarySearch(jobs, i - 2, jobs[i - 1].st);
            f[i] = Math.max(f[i], jobs[i - 1].profit + f[idx + 1]);
        }
        
        return f[n];
    }
    
    private int binarySearch(Job[] jobs, int r, int t) {
        int l = 0;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (jobs[m].ed <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return jobs[l].ed <= t ? l : -1;
    }
    
    public static void main(String[] args) {
        int[] st = {1, 2, 3, 4, 6}, ed = {3, 5, 10, 6, 9}, pr = {20, 20, 100, 70, 60};
        System.out.println(new Solution().jobScheduling(st, ed, pr));
    }
}
