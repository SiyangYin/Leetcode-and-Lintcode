import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.get(triangle.size() - 1).size()];
        Arrays.fill(res, Integer.MAX_VALUE);
        
        res[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size() - 1; j > 0; j--) {
                res[j] = Math.min(res[j], res[j - 1]) + triangle.get(i).get(j);
            }
            res[0] += triangle.get(i).get(0);
        }
    
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < res.length; i++) {
            ans = Math.min(ans, res[i]);
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>(){{
            add(new ArrayList<>(){{
                add(2);
            }});
            add(new ArrayList<>(){{add(3);add(4);}});
            add(new ArrayList<>(){{add(6);add(5);add(7);}});
            add(new ArrayList<>(){{add(4);add(1);add(8);add(3);}});
        }};
    
        System.out.println(triangle);
        System.out.println(new Solution().minimumTotal(triangle));
    }
}
