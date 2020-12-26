import java.util.Arrays;

public class Solution {
    /**
     * @param number: an only contains from 1 to 9 array
     * @return: return  whether or not each sliding window position contains all the numbers for 1 to 9
     */
    public boolean[] SlidingWindows(int[][] number) {
        // write your code here
        int[] count = new int[10], ones = new int[10];
        Arrays.fill(ones, 1);
        ones[0] = 0;
        
        boolean[] res = new boolean[number[0].length - 2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                count[number[i][j]]++;
            }
        }
        
        res[0] = Arrays.equals(count, ones);
    
        for (int j = 3; j < number[0].length; j++) {
            for (int i = 0; i < 3; i++) {
                count[number[i][j - 3]]--;
            }
            for (int i = 0; i < 3; i++) {
                count[number[i][j]]++;
            }
            
            res[j - 2] = Arrays.equals(count, ones);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] num = {{1,2,3,2,5,7},{4,5,6,1,7,6},{7,8,9,4,8,3}};
        System.out.println(Arrays.toString(new Solution().SlidingWindows(num)));
    }
}
