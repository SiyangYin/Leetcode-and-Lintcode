import java.util.List;

public class Solution {
    /**
     * @param cost: The cost of each interviewer
     * @return: The total cost of all the interviewers.
     */
    public int TotalCost(List<List<Integer>> cost) {
        // write your code here
        int res = 0;
        cost.sort((c1, c2) -> -Integer.compare(c1.get(0) - c1.get(1), c2.get(0) - c2.get(1)));
        for (int i = 0; i < cost.size(); i++) {
            if (i < cost.size() / 2) {
                res += cost.get(i).get(1);
            } else {
                res += cost.get(i).get(0);
            }
        }
        
        return res;
    }
}
