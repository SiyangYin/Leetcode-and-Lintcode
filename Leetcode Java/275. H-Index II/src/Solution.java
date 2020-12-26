public class Solution {
    public int hIndex(int[] citations) {
        int l = 0, r = citations.length;
        while (l < r) {
            int mid = l + ((r - l + 1) >> 1);
            if (citations[citations.length - mid] >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        
        return l;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(new Solution().hIndex(new int[]{1}));
    }
}
