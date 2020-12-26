import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param A: the array in problem.
     * @return: represent the new number.
     */
    public String Combine(List<Integer> A) {
        // write your code here
        String[] strs = new String[A.size()];
        int sum = 0;
        int[] mod3 = new int[3];
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            sum += num;
            mod3[num % 3]++;
            strs[i] = String.valueOf(num);
        }
        
        Arrays.sort(strs, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            } else {
                return s1.compareTo(s2);
            }
        });
        
        int delCount = 0, mod = 0;
        if (sum % 3 == 1) {
            if (mod3[1] > 0) {
                delCount = mod = 1;
            } else {
                delCount = 2;
                mod = 2;
            }
        } else if (sum % 3 == 2) {
            if (mod3[2] > 0) {
                delCount = 1;
                mod = 2;
            } else {
                delCount = 2;
                mod = 1;
            }
        }
        
        for (int i = 0; i < strs.length; i++) {
            String n = strs[i];
            if (delCount > 0 && Integer.parseInt(n) % 3 == mod) {
                delCount--;
                strs[i] = "";
            }
        }
        
        Arrays.sort(strs, (s1, s2) -> {
            if (s1.isEmpty() || s2.isEmpty()) {
                return Integer.compare(s1.length(), s2.length());
            } else {
                return -(s1 + s2).compareTo(s2 + s1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        
        return sb.substring(i);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().Combine(Arrays.asList(1, 2, 2)));
        System.out.println(new Solution().Combine(Arrays.asList(3, 0, 6, 9, 2, 1)));
        System.out.println(new Solution().Combine(Arrays.asList(1, 2, 4, 6)));
        System.out.println(new Solution().Combine(Arrays.asList(11, 5, 78, 9, 60, 31, 32, 34, 51, 111)));
    }
}
