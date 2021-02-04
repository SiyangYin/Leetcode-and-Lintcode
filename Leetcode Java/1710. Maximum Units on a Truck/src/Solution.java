import java.util.Arrays;

public class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res = 0;
        Arrays.sort(boxTypes, (b1, b2) -> -Integer.compare(b1[1], b2[1]));
        for (int[] boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                res += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                res += truckSize * boxType[1];
                break;
            }
        }
        
        return res;
    }
}
