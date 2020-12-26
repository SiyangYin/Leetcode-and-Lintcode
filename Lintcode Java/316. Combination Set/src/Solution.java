import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param num: a array
     * @param target: a num
     * @return: return all combinations
     */
    public List<Integer> combinationSet(List<Integer> num, int target) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(0, num, target, res);
        return res;
    }
    
    private void dfs(int cur, List<Integer> num, int target, List<Integer> res) {
        for (int i = 0; i < num.size(); i++) {
            cur = cur * 10 + num.get(i);
            if (cur < target) {
                res.add(cur);
                if (cur > 0) {
                    dfs(cur, num, target, res);
                }
            }
            
            cur = (cur - num.get(i)) / 10;
        }
    }
    
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 1);
        System.out.println(new Solution().combinationSet(list, 30));
    }
}
