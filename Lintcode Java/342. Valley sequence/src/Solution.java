import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param num: sequence
     * @return: The longest valley sequence
     */
    public int valley(int[] num) {
        // write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int n = num.length;
        int[] dpL = new int[n], dpR = new int[n];
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(num[i], new ArrayList<>());
            map.get(num[i]).add(i);
            
            dpL[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (num[j] > num[i]) {
                    dpL[i] = Math.max(dpL[i], dpL[j] + 1);
                }
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            dpR[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (num[i] < num[j]) {
                    dpR[i] = Math.max(dpR[i], dpR[j] + 1);
                }
            }
        }
        
        int res = 0;
        for (int x : num) {
            List<Integer> list = map.get(x);
            
            if (list == null || list.size() == 1) {
                continue;
            }
            
            for (int j = 0; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    res = Math.max(res, Math.min(dpL[list.get(j)], dpR[list.get(k)]) * 2);
                }
            }
            
            map.remove(x);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().valley(new int[]{5, 4, 3, 2, 1, 2, 3, 4, 5}));
    }
}
