import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, candidates, new ArrayList<>(), res, new boolean[candidates.length], 0, target);
        return res;
    }

    public void dfs(int start, int[] A, List<Integer> list, List<List<Integer>> res, boolean[] used, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < A.length; i++) {
            if (i > 0 && !used[i - 1] && A[i - 1] == A[i]) {
                continue;
            }
            if (sum + A[i] <= target) {
                used[i] = true;
                list.add(A[i]);
                dfs(i + 1, A, list, res, used, sum + A[i], target);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(new Solution1().combinationSum2(new int[]{1, 2, 2, 2, 5}, 5));
    }
}
