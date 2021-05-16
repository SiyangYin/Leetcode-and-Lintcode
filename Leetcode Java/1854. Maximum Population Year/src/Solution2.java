public class Solution2 {
    final int BASE = 1950;
    
    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[102];
        for (int[] log : logs) {
            diff[log[0] - BASE]++;
            diff[log[1] - BASE]--;
        }
        
        int[] pop = new int[101];
        pop[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            pop[i] = pop[i - 1] + diff[i];
        }
        
        int res = -1, cnt = 0;
        for (int i = 0; i < pop.length; i++) {
            if (pop[i] > cnt) {
                cnt = pop[i];
                res = i + BASE;
            }
        }
        
        return res;
    }
}
