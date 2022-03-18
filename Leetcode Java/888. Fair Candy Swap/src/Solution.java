import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        for (int x : aliceSizes) {
            sumA += x;
        }
        
        Set<Integer> setB = new HashSet<>();
        for (int x : bobSizes) {
            sumB += x;
            setB.add(x);
        }
    
        for (int x : aliceSizes) {
            if (setB.contains(x + (sumB - sumA >> 1))) {
                return new int[]{x, x + (sumB - sumA >> 1)};
            }
        }
        
        return null;
    }
}
