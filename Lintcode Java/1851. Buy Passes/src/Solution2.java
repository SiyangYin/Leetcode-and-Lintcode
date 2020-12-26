public class Solution2 {
    /**
     * @param arr: the line
     * @param k:   Alex place
     * @return: the time when Alex requires to buy all passes
     */
    public int buyPasses(int[] arr, int k) {
        // Write your code here.
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i <= k; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                count++;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[k]) {
                count += arr[i];
            } else {
                count += arr[k];
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().buyPasses(new int[]{1, 2, 5}, 1));
        System.out.println(new Solution2().buyPasses(new int[]{3, 2, 1}, 0));
    }
}
