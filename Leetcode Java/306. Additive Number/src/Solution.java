public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            for (int j = i + 1; j + 1 < num.length(); j++) {
                // 199100199
                
                int idx1 = -1, idx2 = i, idx3 = j;
                while (true) {
                    if (idx2 - idx1 > 1 && num.charAt(idx1 + 1) == '0' || idx3 - idx2 > 1 && num.charAt(idx2 + 1) == '0') {
                        break;
                    }
                    
                    String n1 = num.substring(idx1 + 1, idx2 + 1), n2 = num.substring(idx2 + 1, idx3 + 1);
                    String n3 = sum(n1, n2);
                    
                    if (idx3 + n3.length() >= num.length()) {
                        break;
                    }
                    
                    if (!n3.equals(num.substring(idx3 + 1, idx3 + n3.length() + 1))) {
                        break;
                    }
                    
                    idx1 = idx2;
                    idx2 = idx3;
                    idx3 += n3.length();
                    if (idx3 + 1 == num.length()) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private String sum(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i1 = s1.length() - 1, i2 = s2.length() - 1;
        int carry = 0;
        while (i1 >= 0 || i2 >= 0) {
            if (i1 >= 0) {
                carry += s1.charAt(i1) - '0';
                i1--;
            }
            if (i2 >= 0) {
                carry += s2.charAt(i2) - '0';
                i2--;
            }
            
            sb.append(carry % 10);
            carry /= 10;
        }
        
        if (carry == 1) {
            sb.append(1);
        }
        
        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("112358"));
        System.out.println(new Solution().isAdditiveNumber("199100199"));
        System.out.println(new Solution().isAdditiveNumber("101"));
    }
}

