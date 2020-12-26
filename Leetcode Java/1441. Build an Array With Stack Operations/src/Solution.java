import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        if (target == null || target.length == 0) {
            return res;
        }
        
        String pu = "Push", po = "Pop";
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (target[idx] == i) {
                res.add(pu);
                idx++;
            } else {
                res.add(pu);
                res.add(po);
            }
            
            if (idx == target.length) {
                break;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[]{2, 3, 4}, 4));
    }
}
