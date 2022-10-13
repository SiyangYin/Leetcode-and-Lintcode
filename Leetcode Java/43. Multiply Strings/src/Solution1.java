import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public String multiply(String num1, String num2) {
        char[] ca1 = num1.toCharArray();
        char[] ca2 = num2.toCharArray();
        List<List<Integer>> res = new ArrayList<>();
        int carry = 0;
        for (int i = ca1.length - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();
            carry =  0;
            for (int j = ca2.length - 1; j >= 0; j--) {
                int val = (int) (ca1[i] - '0') * (int) (ca2[j] - '0') + carry;
                carry = val / 10;
                val %= 10;
                list.add(val);
            }
            list.add(carry);
            res.add(list);
        }
        carry = 0;
        int length = res.get(0).size();
        for (int i = 1; i <= res.get(0).size(); i++) {
            int val = 0;
            for (int j = Math.max(i - length + 1, 0); j <= Math.min(res.size() - 1, i); j++) {
                val += res.get(j).get(i - j);
            }
            val += carry;
            carry = val / 10;
            val %= 10;
            if (i < res.get(0).size()) {
                res.get(0).set(i, val);
            }
            else if (res.size() != 1 && i < res.size() + res.get(res.size() - 1).size() - 1) {
                res.get(0).add(val);
            }
        }
        StringBuilder sb = new StringBuilder();
        int j = res.get(0).size() - 1;
        while (j > 0 && res.get(0).get(j) == 0) j--;
        for (int i = j; i >= 0; i--) {
            sb.append(res.get(0).get(i));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution1().multiply("9", "9"));
    }
}
