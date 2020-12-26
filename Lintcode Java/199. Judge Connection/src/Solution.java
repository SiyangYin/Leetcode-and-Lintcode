public class Solution {
    /**
     * @param arr: the arr
     * @param k:   the k
     * @return: if all instances of value k in arr are connected
     */
    public boolean judgeConnection(int[][] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0 || arr[0].length == 0) {
            return true;
        }
        
        boolean changed = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == k) {
                    if (changed) {
                        return false;
                    }
                    
                    dfs(i, j, arr, k);
                    changed = true;
                }
            }
        }
        
        return true;
    }
    
    private void dfs(int x, int y, int[][] arr, int k) {
        if (!inBound(x, y, arr) || arr[x][y] != k) {
            return;
        }
        
        arr[x][y] = k - 1;
        dfs(x + 1, y, arr, k);
        dfs(x - 1, y, arr, k);
        dfs(x, y + 1, arr, k);
        dfs(x, y - 1, arr, k);
    }
    
    private boolean inBound(int x, int y, int[][] arr) {
        return 0 <= x && x < arr.length && 0 <= y && y < arr[0].length;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{2, 2, 2, 0},
                {0, 0, 0, 2},
                {0, 1, 0, 2},
                {1, 1, 1, 2}};
        System.out.println(new Solution().judgeConnection(arr, 0));
    }
}
