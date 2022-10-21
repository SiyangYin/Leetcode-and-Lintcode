import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = 0;
                if (j == 0) {
                    val = triangle.get(i - 1).get(0);
                }
                else if (j == i) {
                    val = triangle.get(i - 1).get(i - 1);
                }
                else {
                    val = Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j));
                }
                triangle.get(i).set(j, val + triangle.get(i).get(j));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            if (triangle.get(triangle.size() - 1).get(i) < min) {
                min = triangle.get(triangle.size() - 1).get(i);
            }
        }
        return min;
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
        System.out.println(new Solution1().minimumTotal(triangle));
    }
}
