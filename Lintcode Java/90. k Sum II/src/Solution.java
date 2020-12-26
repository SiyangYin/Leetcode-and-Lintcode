import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param A: an integer array
     * @param k: a postive integer <= length(A)
     * @param target: an integer
     * @return: A list of lists of integer
     */
    public List<List<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
    
        Arrays.sort(A);
        
        dfs(A, k, target, 0, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int[] A, int k, int target, int pos, List<Integer> cur, List<List<Integer>> res) {
        if (target == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = pos; k - cur.size() <= A.length - i; i++) {
            if (cur.size() == k) {
                break;
            }
            
            if (target >= A[i]) {
                cur.add(A[i]);
                dfs(A, k, target - A[i], i + 1, cur, res);
                cur.remove(cur.size() - 1);
            } else {
                break;
            }
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kSumII(new int[]{1, 2, 3, 4}, 2, 5));
    }
}
