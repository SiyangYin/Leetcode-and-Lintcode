import java.util.List;

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int res = 0, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                res = nums.get(i);
                count++;
            } else {
                if (nums.get(i) != res) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        
        return res;
    }
}