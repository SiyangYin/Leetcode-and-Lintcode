public class Solution {
    
    public static void main(String[] args) {
        System.out.println(new Solution().totalNQueens(8));
    }
    
    int count = 0;
    
    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }
        
        int[] pos = new int[n];
        dfs(pos, 0);
        return count;
    }
    
    private void dfs(int[] pos, int k) {
        if (k == pos.length) {
            count++;
        }
    
        for (int i = 0; i < pos.length; i++) {
            if (check(pos, k, i)) {
                pos[k] = i;
                dfs(pos, k + 1);
            }
        }
    }
    
    // 尝试在第k行的第i个位置放皇后
    private boolean check(int[] pos, int k, int i) {
        for (int dif = 1; dif <= k; dif++) {
            if (i - dif >= 0 && pos[k - dif] == i - dif) {
                return false;
            }
            if (i + dif < pos.length && pos[k - dif] == i + dif) {
                return false;
            }
            if (pos[k - dif] == i) {
                return false;
            }
        }
        return true;
    }
}
