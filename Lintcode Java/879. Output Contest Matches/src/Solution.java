import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: a integer, denote the number of teams
     * @return: a string
     */
    public String findContestMatch(int n) {
        // write your code here
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        
        while (list.size() > 1) {
            List<String> tmp = new ArrayList<>();
            for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
                tmp.add('(' + list.get(i) + ',' + list.get(j) + ')');
            }
            
            list = tmp;
        }
        
        return list.get(0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findContestMatch(8));
    }
}
