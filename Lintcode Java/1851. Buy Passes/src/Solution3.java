public class Solution3 {
    /**
     * @param arr: the line
     * @param k: Alex place
     * @return: the time when Alex requires to buy all passes
     */
    public int buyPasses(int[] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int time = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i <= k) {
                time += Math.min(arr[i], arr[k]);
            } else {
                time += Math.min(arr[i], arr[k] - 1);
            }
        }
        
        return time;
    }
}
