public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        
        int res = sum >= threshold * k ? 1 : 0;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            res += sum >= threshold * k ? 1 : 0;
        }
        
        return res;
    }
}
