import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        for (String op : ops) {
            int size = list.size();
            if ("C".equals(op)) {
                list.remove(size - 1);
            } else if ("D".equals(op)) {
                list.add(list.get(size - 1) * 2);
            } else if ("+".equals(op)) {
                list.add(list.get(size - 1) + list.get(size - 2));
            } else {
                list.add(Integer.parseInt(op));
            }
        }
        
        int res = 0;
        for (int num : list) {
            res += num;
        }
        
        return res;
    }
}
