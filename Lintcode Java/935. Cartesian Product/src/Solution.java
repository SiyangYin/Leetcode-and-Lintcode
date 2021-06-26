import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param setList: The input set list
     * @return: the cartesian product of the set list
     */
    public List<List<Integer>> getSet(int[][] setList) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<>();
        dfs(new ArrayList<>(), 0, setList, res);
        return res;
    }
    
    private void dfs(List<Integer> cur, int depth, int[][] lists, List<List<Integer>> res) {
        if (depth == lists.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
    
        for (int i = 0; i < lists[depth].length; i++) {
            cur.add(lists[depth][i]);
            dfs(cur, depth + 1, lists, res);
            cur.remove(cur.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        int[][] s = {{1,2,3},{4,},{5,6}};
        System.out.println(new Solution().getSet(s));
    }
}
