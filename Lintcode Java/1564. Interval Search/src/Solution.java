import java.util.List;

public class Solution {
    /**
     * @param intervalList:
     * @param number:
     * @return: return True or False
     */
    public String isInterval(List<List<Integer>> intervalList, int number) {
        // Write your code here
        for (List<Integer> interval : intervalList) {
            if (interval.get(0) <= number && number <= interval.get(1)) {
                return "True";
            }
        }
        
        return "False";
    }
}
