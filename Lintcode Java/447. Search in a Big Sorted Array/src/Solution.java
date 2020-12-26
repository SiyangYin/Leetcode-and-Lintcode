import java.util.ArrayList;

public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayList<Integer> reader, int target) {
        // write your code here
        int k = 1;
        while (reader.get(k) < target) {
            k *= 2;
        }
    
        int l = 0, r = k;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (reader.get(m) < target) {
                l = m + 1;
            } else if (reader.get(m) > target) {
                r = m - 1;
            } else {
                r = m;
            }
        }
    
        if (reader.get(l) == target) {
            return l;
        } else {
            return -1;
        }
    }
}
