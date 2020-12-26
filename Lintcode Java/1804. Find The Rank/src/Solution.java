public class Solution {
    
    class Pair {
        int idx, sum;
        
        public Pair(int idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }
    
    /**
     * @param scores: two dimensional array
     * @param K:      a integer
     * @return: return a integer
     */
    public int FindTheRank(int[][] scores, int K) {
        // write your code here
        int len = scores.length;
        Pair[] pairs = new Pair[len];
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int score : scores[i]) {
                sum += score;
            }
            
            pairs[i] = new Pair(i, sum);
        }
        
        partition(pairs, 0, len - 1, len - K);
        return pairs[len - K].idx;
    }
    
    private void partition(Pair[] pairs, int l, int r, int idx) {
        int m = l + (r - l >> 1);
        swap(pairs, l, m);
        Pair piv = pairs[l];
        
        int i = l, j = r;
        while (i < j) {
            while (i < j && pairs[j].sum >= piv.sum) {
                j--;
            }
            pairs[i] = pairs[j];
            while (i < j && pairs[i].sum <= piv.sum) {
                i++;
            }
            pairs[j] = pairs[i];
        }
        
        pairs[i] = piv;
        if (i > idx) {
            partition(pairs, l, i - 1, idx);
        } else if (i < idx) {
            partition(pairs, i + 1, r, idx);
        }
    }
    
    private void swap(Pair[] pairs, int i, int j) {
        Pair tmp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[][] sc = {{90, 80, 70}, {90, 90, 90}, {60, 60, 60}};
        System.out.println(new Solution().FindTheRank(sc, 1));
    }
}
