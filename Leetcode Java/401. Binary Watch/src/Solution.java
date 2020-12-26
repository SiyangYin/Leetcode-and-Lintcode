import java.util.*;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        Map<Integer, List<Integer>> memo = new HashMap<>();
        
        for (int i = 0; i <= Math.min(num, 4); i++) {
            for (Integer hour : generateNums(i, memo)) {
                if (hour <= 11) {
                    for (Integer min : generateNums(num - i, memo)) {
                        res.add(String.format("%d:%02d", hour, min));
                    }
                }
            }
        }
        return res;
    }
    
    private List<Integer> generateNums(int n, Map<Integer, List<Integer>> memo) {
        List<Integer> nums = memo.get(n);
        if (nums == null) {
            nums = new ArrayList<>();
            dfs(nums, n, 0, 0, 0);
            memo.put(n, nums);
        }
        return nums;
    }
    
    private void dfs(List<Integer> nums, int n, int pos, int sum, int count) {
        if (count == n) {
            nums.add(sum);
            return;
        }
    
        for (int i = pos; i < 6; i++) {
            sum += 1 << i;
            if (sum < 60) {
                dfs(nums, n, i + 1, sum, count + 1);
            }
            sum -= 1 << i;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    
        System.out.println(Integer.toBinaryString(59));
    }
}
