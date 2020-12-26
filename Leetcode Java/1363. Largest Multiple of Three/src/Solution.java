public class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] count = new int[10], mod3 = new int[3];
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
            mod3[digits[i] % 3]++;
            count[digits[i]]++;
        }
        
        int delCount = 0, mod = 0;
        if (sum % 3 == 1) {
            if (mod3[1] >= 1) {
                delCount = 1;
                mod = 1;
            } else {
                delCount = 2;
                mod = 2;
            }
        } else if (sum % 3 == 2) {
            if (mod3[2] >= 1) {
                delCount = 1;
                mod = 2;
            } else {
                delCount = 2;
                mod = 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (delCount > 0 && i % 3 == mod) {
                    delCount--;
                } else {
                    sb.append(i);
                }
            }
        }
        
        sb.reverse();
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        
        return sb.substring(i);
    }
    
}
