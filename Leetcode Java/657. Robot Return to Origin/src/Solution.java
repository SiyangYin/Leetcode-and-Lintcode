public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                x--;
            } else if (c == 'D') {
                x++;
            } else if (c == 'L') {
                y--;
            } else if (c == 'R') {
                y++;
            }
        }
     
        return x == 0 && y == 0;
    }
}
