import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    
    public static void main(String[] args) {
        System.out.println(new Solution2().judgePoint24(new int[]{4, 1, 8, 7}));
        System.out.println(new Solution2().judgePoint24(new int[]{1, 2, 1, 2}));
    }
    
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int num : nums) {
            list.add((double) num);
        }
        
        return dfs(list);
    }
    
    private boolean dfs(List<Double> list) {
        if (list.size() == 1 && isZero(list.get(0) - 24)) {
            return true;
        }
    
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                double x = list.remove(j);
                double y = list.remove(i);
                
                list.add(x + y);
                if (dfs(list)) {
                    return true;
                }
                list.remove(list.size() - 1);
    
                list.add(x - y);
                if (dfs(list)) {
                    return true;
                }
                list.remove(list.size() - 1);
    
                list.add(y - x);
                if (dfs(list)) {
                    return true;
                }
                list.remove(list.size() - 1);
    
                list.add(x * y);
                if (dfs(list)) {
                    return true;
                }
                list.remove(list.size() - 1);
                
                if (!isZero(y)) {
                    list.add(x / y);
                    if (dfs(list)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
                if (!isZero(x)) {
                    list.add(y / x);
                    if (dfs(list)) {
                        return true;
                    }
                    list.remove(list.size() - 1);
                }
                
                list.add(i, y);
                list.add(j, x);
            }
        }
        
        return false;
    }
    
    
    private boolean isZero(double x) {
        return Math.abs(x) < 1e-5;
    }
}
