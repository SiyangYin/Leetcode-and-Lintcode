public class Solution {
    /**
     * @reader: reader.get(k) returns the element of the array at index k (0-indexed).
     * @return: return target index
     */
    public int search(ArrayReader reader, int target) {
        // write your code here
        int r = 1;
        while (reader.get(r) < target) {
            r <<= 1;
        }
        
        int l = 0;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (reader.get(m) <= target) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return reader.get(l) == target ? l : -1;
    }
}

interface ArrayReader {
    int get(int k);
}