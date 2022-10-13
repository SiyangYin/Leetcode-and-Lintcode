import java.util.*;

public class Solution1 {
    private int min = Integer.MAX_VALUE;
    private Set<Integer> memo = new HashSet<>();

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        dfs(nums, 0, 1);
        return min;
    }

    public void dfs(int[] nums, int i, int jump) {
        if (jump >= min) return;
        if (i + nums[i] >= nums.length - 1) {
            min = jump;
            memo.add(i);
            return;
        }
        List<int[]> list = new ArrayList<>();
        for (int j = Math.min(nums[i], nums.length - i - 1); j >= 1; j--) {
            list.add(new int[] {i + j + nums[i + j], i + j});
            if (memo.contains(i + j) && !memo.contains(i)) {
                memo.add(i);
            }
        }
        Collections.sort(list, (a1, a2) -> a2[0] - a1[0]);
        for (int[] a : list) {
            if (!memo.contains(a[1])) {
                int prev = min;
                dfs(nums, a[1], jump + 1);
                if (prev == min) return;
            }
            else {
                return;
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution1().jump(new int[]{1, 2, 1, 1, 1}));
        System.out.println(new Solution1().jump(new int[]{0}));
        System.out.println(new Solution1().jump(new int[]{1}));
        System.out.println(new Solution1().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }
}
