import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    public String multiply(String num1, String num2) {
        char[] ca1 = num1.toCharArray();
        char[] ca2 = num2.toCharArray();
        int carry = 0;
        List<Integer> list = new ArrayList<>(Collections.nCopies(ca2.length, 0));
        for (int i = ca1.length - 1; i >= 0; i--) {
            carry = 0;
            for (int j = ca2.length - 1; j >= 0; j--) {
                int val = (int) (ca1[i] - '0') * (int) (ca2[j] - '0') + carry;
                val += list.get(ca2.length + ca1.length - i - j - 2);
                carry = val / 10;
                val %= 10;
                list.set(ca2.length + ca1.length - i - j - 2, val);
            }
            list.add(carry);
        }
        StringBuilder sb = new StringBuilder();
         int j = list.size() - 1;
         while (j > 0 && list.get(j) == 0) j--;
         for (int i = j; i >= 0; i--) {
             sb.append(list.get(i));
         }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution2().multiply("9", "9"));
    }
}
