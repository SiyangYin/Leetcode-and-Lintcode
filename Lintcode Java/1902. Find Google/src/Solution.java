import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param S: The c++ file
     * @return: return if there is "Google" in commet line
     */
    public boolean FindGoogle(List<String> S) {
        // Write your code here.
        int last = -1;
        for (int i = 0; i < S.size(); i++) {
            String s = S.get(i);
            int a = s.indexOf("//"), b = s.indexOf("Google"), c = s.indexOf("/*"), d = s.indexOf("*/");
            if (a != -1 && a < b) {
                return true;
            }
            
            if (c != -1 && (a > c || a == -1)) {
                last = i;
            }
            
            if (b != -1) {
                if (c != -1 && d != -1) {
                    if (c < b && b < d) {
                        return true;
                    }
                } else if (c != -1) {
                    if (c < b) {
                        return true;
                    }
                } else if (d != -1) {
                    if (b < d) {
                        return true;
                    }
                } else {
                    if (last != -1 && last < i) {
                        return true;
                    }
                }
            }
            
            if (d != -1) {
                last = -1;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().FindGoogle(Arrays.asList("#include<bits/stdc++.h>",
                "using namespace std;",
                "int main(){",
                "/* //",
                "Google",
                "*/",
                "return 0;",
                "}")));
    }
}
