public class Solution {
    /**
     * @param boxes:  number of pens for each box
     * @param target: the target number
     * @return: the minimum boxes
     */
    public int minimumBoxes(int[] boxes, int target) {
        // write your code here
        int len = boxes.length;
        int[] lShort = new int[len], preSum = new int[len + 1];
        for (int i = 0; i < boxes.length; i++) {
            preSum[i + 1] = preSum[i] + boxes[i];
        }
        
        for (int i = 1, j = 0; i <= len; i++) {
            while (preSum[i] - preSum[j] > target) {
                j++;
            }
            
            if (preSum[i] - preSum[j] == target) {
                lShort[i - 1] = i - j;
            } else if (i - 1 > 0) {
                lShort[i - 1] = lShort[i - 2];
            }
        }
        
        int res = len + 1;
        for (int i = len - 1, j = len; i >= 1; i--) {
            while (preSum[j] - preSum[i] > target) {
                j--;
            }
            
            if (preSum[j] - preSum[i] == target && lShort[i - 1] != 0) {
                res = Math.min(res, lShort[i - 1] + j - i);
            }
        }
        
        return res == len + 1 ? -1 : res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().minimumBoxes(new int[]{1, 2, 2, 1, 1, 1}, 3));
        System.out.println(new Solution().minimumBoxes(new int[]{2, 1, 4, 5, 2, 9, 7}, 9));
    }
}
