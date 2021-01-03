public class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) {
            int leftGreater = 0, rightGreater = 0, leftSmaller = 0, rightSmaller = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] > rating[i]) {
                    leftGreater++;
                } else {
                    leftSmaller++;
                }
            }
            
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] > rating[i]) {
                    rightGreater++;
                } else {
                    rightSmaller++;
                }
            }
            
            res += leftSmaller * rightGreater;
            res += leftGreater * rightSmaller;
        }
        
        return res;
    }
}
