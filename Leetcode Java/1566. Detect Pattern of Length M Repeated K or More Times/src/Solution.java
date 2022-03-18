public class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0, j = i + m, cnt = 0; j < arr.length; i++, j++) {
            if (arr[i] != arr[j]) {
                cnt = 0;
            } else if (++cnt == (k - 1) * m) {
                return true;
            }
        }
        
        return false;
    }
}
