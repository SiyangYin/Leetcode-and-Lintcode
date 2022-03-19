public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        for (int i = 0, j = 0; i < name.length() || j < typed.length(); i++, j++) {
            if (i == name.length() || j == typed.length()) {
                return false;
            }
            
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            
            int ii = i;
            while (ii < name.length() && name.charAt(ii) == name.charAt(i)) {
                ii++;
            }
            int jj = j;
            while (jj < typed.length() && typed.charAt(jj) == typed.charAt(j)) {
                jj++;
            }
            
            if (ii - i > jj - j) {
                return false;
            }
            
            i = ii - 1;
            j = jj - 1;
        }
        
        return true;
    }
}
