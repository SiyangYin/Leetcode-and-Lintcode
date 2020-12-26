import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (fizzbuzz(i) == null) {
                list.add(String.valueOf(i));
            } else {
                list.add(fizzbuzz(i));
            }
        }
        return list;
    }
    
    private String fizzbuzz(int n) {
        if (n % 3 == 0 && n % 5 == 0) {
            return "fizz buzz";
        }
        if (n % 3 == 0) {
            return "fizz";
        }
        if (n % 5 == 0) {
            return "buzz";
        }
        return null;
    }
}