public class Solution {
    /**
     * @param moves: a string of its moves
     * @return: if the robot return to origin
     */
    public boolean robotReturntoOrigin(String moves) {
        // Write your code here.
        int U, D, L, R;
        U = D = L = R = 0;
    
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U': U++; break;
                case 'D': D++; break;
                case 'L': L++; break;
                case 'R': R++; break;
            }
        }
        
        return U == D && L == R;
    }
}
