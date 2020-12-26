import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param circles: The value of 6 points on n rings
     * @return: Whether there are two same circles
     */
    public boolean samecircle(int[][] circles) {
        // write your code here
        Set<String> set = new HashSet<>();
        for (int i = 0; i < circles.length; i++) {
            StringBuilder sb = new StringBuilder();
            Arrays.sort(circles[i]);
            for (int j = 0; j < circles[i].length; j++) {
                sb.append(circles[i][j]).append(' ');
            }
            
            if (set.contains(sb.toString())) {
                return true;
            }
            
            set.add(sb.toString());
        }
        
        return false;
    }
}
