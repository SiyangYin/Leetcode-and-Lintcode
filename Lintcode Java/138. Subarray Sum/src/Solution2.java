import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2 {
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum));
                res.add(i);
                return res;
            } else {
                map.put(sum, i + 1);
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().subarraySum(new int[]{-3, 1, 2, -3, 4}));
    }
}
