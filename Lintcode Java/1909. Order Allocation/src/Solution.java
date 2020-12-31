import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    private int max;
    
    /**
     * @param score: When the j-th driver gets the i-th order, we can get score[i][j] points.
     * @return: return an array that means the array[i]-th driver gets the i-th order.
     */
    public int[] orderAllocation(int[][] score) {
        // write your code here
        int n = score.length;
        int[] res = new int[n];
        dfs(0, 0, score, new boolean[n], new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int n, int sum, int[][] score, boolean[] visited, List<Integer> list, int[] res) {
        if (n == score.length) {
            if (sum > max) {
                max = sum;
                for (int i = 0; i < res.length; i++) {
                    res[i] = list.get(i);
                }
            }
            
            return;
        }
        
        for (int i = 0; i < score[0].length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(n + 1, sum + score[n][i], score, visited, list, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] s = {{1, 2, 4}, {7, 11, 16}, {37, 29, 22}};
        System.out.println(Arrays.toString(new Solution().orderAllocation(s)));
    }
}
