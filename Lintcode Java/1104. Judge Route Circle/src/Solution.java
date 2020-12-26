public class Solution {
    /**
     * @param moves: a sequence of its moves
     * @return: if this robot makes a circle
     */
    public boolean judgeCircle(String moves) {
        // Write your code here
        int U = 0, R = 0;
        for (int i = 0; i < moves.length(); i++) {
            char m = moves.charAt(i);
            if (m == 'U') {
                U++;
            } else if (m == 'D') {
                U--;
            } else if (m == 'R') {
                R++;
            } else {
                R--;
            }
        }
        
        return U == 0 && R == 0;
    }
}
