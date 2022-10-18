import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    
    public static void main(String[] args) {
        System.out.println(new Solution1().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i + 1, n, k, list, res);
            list.remove(list.size() - 1);
        }
    }
}
