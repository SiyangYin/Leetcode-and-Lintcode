import java.util.List;

public class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int col = dim.get(1);
        int l = 0, r = col - 1;
        while (l < r) {
            int mid = l + (r - l >> 1);
            if (check(mid, binaryMatrix)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        return check(l, binaryMatrix) ? l : -1;
    }
    
    private boolean check(int col, BinaryMatrix binaryMatrix) {
        for (int i = 0; i < binaryMatrix.dimensions().get(0); i++) {
            if (binaryMatrix.get(i, col) == 1) {
                return true;
            }
        }
        
        return false;
    }
}

interface BinaryMatrix {
    int get(int row, int col);
    
    List<Integer> dimensions();
}