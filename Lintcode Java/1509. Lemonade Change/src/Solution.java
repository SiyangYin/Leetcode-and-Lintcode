import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param bills: the Bill
     * @return: Return true if and only if you can provide every customer with correct change.
     */
    public boolean lemonadeChange(List<Integer> bills) {
        // Write your code here.
        int five = 0, ten = 0;
        for (int i = 0; i < bills.size(); i++) {
            int cur = bills.get(i);
            if (cur == 5) {
                five++;
            } else if (cur == 10) {
                five--;
                if (five < 0) {
                    return false;
                }
                ten++;
            } else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(Arrays.asList(5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5, 5, 5, 10, 5, 20, 5, 5, 5, 5, 5, 20, 5, 10, 5, 5, 5, 5, 20, 20, 5)));
    }
}
