import java.util.Map;

public class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0, y = 0, dir = 0;
        Map<Integer, int[]> map = Map.of(
                0, new int[]{0, 1},
                1, new int[]{1, 0},
                2, new int[]{0, -1},
                3, new int[]{-1, 0});
        
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            switch (ch) {
                case 'G':
                    int[] d = map.get(dir);
                    x += d[0];
                    y += d[1];
                    break;
                case 'R':
                    dir = (dir + 1) % 4;
                    break;
                case 'L':
                    dir = (dir + 3) % 4;
                    break;
            }
        }
        
        return dir != 0 || (x == 0 && y == 0);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().isRobotBounded("GGLLGG"));
        System.out.println(new Solution().isRobotBounded("GLRLLGLL"));
    }
}
