import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param arr: a positive integer array
     * @param num: a positive integer
     * @return: return the maxium num
     */
    public long maxNum(List<Integer> arr, int num) {
        // write your code here
        arr.sort((i1, i2) -> Integer.compare(i1, i2));
        long res = num;
        for (int n : arr) {
            if (res == n) {
                res <<= 1;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().maxNum(Arrays.asList(1, 2, 1, 3, 2), 1));
    }
}
