public class Solution {
    public int search(ArrayReader reader, int target) {
        int l = 0, r = 1;
        if (reader.get(0) == target) {
            return 0;
        }
        
        while (reader.get(r) < target) {
            l = r;
            r <<= 1;
        }
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (reader.get(m) < target) {
                l = m + 1;
            } else if (reader.get(m) > target) {
                r = m - 1;
            } else {
                return m;
            }
        }
        
        return reader.get(l) == target ? l : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().search(new ArrayReader() {
            @Override
            public int get(int index) {
                int[] arr = {-1, 0, 3, 5, 9, 12};
                return arr[index];
            }
        }, 9));
    }
}

interface ArrayReader {
    int get(int index);
}