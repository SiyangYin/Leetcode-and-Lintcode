import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {
    
    public static void main(String[] args) {
        System.out.println(new Solution3().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, new ArrayList<>(), res, 0, target);
        return res;
    }

    public void dfs(int start, int[] A, List<Integer> list, List<List<Integer>> res, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < A.length; i++) {
            if (sum + A[i] <= target) {
                list.add(A[i]);
                dfs(i, A, list, res, sum + A[i], target);
                list.remove(list.size() - 1);
            }
        }
    }
}
