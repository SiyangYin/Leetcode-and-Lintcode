import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param list1: a list of strings
     * @param list2: a list of strings
     * @return: the common interest with the least list index sum
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        // Write your code here
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < list1.length + list2.length - 1; i++) {
            for (int j = 0; j <= i; j++) {
                int idx1 = j, idx2 = i - j;
                if (0 <= idx1 && idx1 < list1.length && 0 <= idx2 && idx2 < list2.length) {
                    String r1 = list1[idx1], r2 = list2[idx2];
                    if (r1.equals(r2)) {
                        res.add(r1);
                    }
                }
            }
            
            if (!res.isEmpty()) {
                break;
            }
        }
        
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        
        return ans;
    }
}
