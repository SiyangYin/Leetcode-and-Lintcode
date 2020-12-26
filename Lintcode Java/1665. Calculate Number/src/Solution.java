import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param num: the num
     * @return: the array subject to the description
     */
    public int[] calculateNumber(int num) {
        // Write your code here.
        int pos = 0;
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            if ((num & 1) == 1) {
                list.add(pos);
            }
            
            num >>= 1;
            pos++;
        }
        
        int[] res = new int[list.size() + 1];
        res[0] = list.size();
        for (int i = 0; i < list.size(); i++) {
            res[i + 1] = list.get(list.size() - 1) - list.get(list.size() - 1 - i) + 1;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(Arrays.toString(new Solution().calculateNumber(10)));
        System.out.println(Arrays.toString(new Solution().calculateNumber(7)));
        System.out.println(Integer.toBinaryString(7));
    }
}
