import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            String[] tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        List<String> ans = new ArrayList<>();
        int minIdxSum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (map.get(list2[i]) + i < minIdxSum) {
                    minIdxSum = map.get(list2[i]) + i;
                    ans.clear();
                    ans.add(list2[i]);
                } else if (map.get(list2[i]) + i == minIdxSum) {
                    ans.add(list2[i]);
                }
            }
        }
        
        String[] res = new String[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        
        return res;
    }
}