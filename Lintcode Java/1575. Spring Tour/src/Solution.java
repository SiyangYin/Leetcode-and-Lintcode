public class Solution {
    /**
     * @param a: The array a
     * @return: Return the minimum number of car
     */
    public int getAnswer(int[] a) {
        // Write your code here
        int res = 0;
        int[] count = new int[5];
        for (int n : a) {
            count[n]++;
        }
        
        res += count[4];
        
        count[1] -= Math.min(count[1], count[3]);
        res += count[3];
        
        res += count[2] >> 1;
        count[2] %= 2;
        
        if (count[1] >= count[2] << 1) {
            res += count[2];
            count[1] -= count[2] << 1;
            res += (count[1] + 3) / 4;
        } else if (count[2] == 1) {
            res++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getAnswer(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().getAnswer(new int[]{1, 4, 1, 2, 2, 1}));
    }
}
