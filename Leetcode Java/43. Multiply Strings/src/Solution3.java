import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public String multiply(String num1, String num2) {
        char[] ca1 = num1.toCharArray();
        char[] ca2 = num2.toCharArray();
        int carry = 0;
        int[] arr = new int[ca1.length + ca2.length];
        for (int i = ca1.length - 1; i >= 0; i--) {
            carry = 0;
            for (int j = ca2.length - 1; j >= 0; j--) {
                int val = (int) (ca1[i] - '0') * (int) (ca2[j] - '0') + carry;
                val += arr[ca2.length + ca1.length - i - j - 2];
                carry = val / 10;
                val %= 10;
                arr[ca2.length + ca1.length - i - j - 2] = val;
            }
            arr[ca2.length + ca1.length - i - 1] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int j = arr.length - 1;
        while (j > 0 && arr[j] == 0) j--;
        for (int i = j; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().multiply("9", "9"));
    }
}
