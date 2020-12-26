public class Solution {
    /**
     * @param arr: an inter array
     * @return: return the min sum
     */
    public int splitArray(int[] arr) {
        // write your code here
        int min1, min2, min3, pos1, pos2, pos3;
        min1 = min2 = min3 = Integer.MAX_VALUE;
        pos1 = pos2 = pos3 = -1;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < min1) {
                min3 = min2;
                min2 = min1;
                min1 = arr[i];
                
                pos3 = pos2;
                pos2 = pos1;
                pos1 = i;
            } else if (arr[i] < min2) {
                min3 = min2;
                min2 = arr[i];
                
                pos3 = pos2;
                pos2 = i;
            } else if (arr[i] < min3) {
                min3 = arr[i];
                
                pos3 = i;
            }
        }
        
        if (Math.abs(pos1 - pos2) > 1) {
            return min1 + min2;
        } else if (Math.abs(pos1 - pos3) > 1) {
            return min1 + min3;
        } else {
            return min2 + min3;
        }
    }
}
