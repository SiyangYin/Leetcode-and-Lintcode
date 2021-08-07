import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            id.add(i);
        }
        
        id.sort((x, y) -> Integer.compare(nums[x], nums[y]));
        int min = n, res = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                res = Math.max(res, id.get(i) - min);
            }
            
            min = Math.min(min, id.get(i));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().maxWidthRamp(new int[]{1, 1, 1, 1, 2, 1}));
    }
}
