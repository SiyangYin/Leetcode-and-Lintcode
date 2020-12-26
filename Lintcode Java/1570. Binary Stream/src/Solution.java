import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param s: the binary stream
     * @return: the outputs
     */
    public int[] getOutput(String s) {
        // Write your code here
        int num = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            num = (num << 1) % 3 + s.charAt(i) - '0';
            if (num % 3 == 0) {
                list.add(i + 1);
            }
        }
        
        // int[] res = new int[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     res[i] = list.get(i);
        // }
    
        // return res;
        return list.stream().mapToInt(k -> k).toArray();
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getOutput("10101111101111111000100000000111111111000000000111111100000000111000000000101101010010001010101010101010")));
    }
}
