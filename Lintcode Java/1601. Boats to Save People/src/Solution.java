import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param people: The i-th person has weight people[i].
     * @param limit: Each boat can carry a maximum weight of limit.
     * @return: Return the minimum number of boats to carry every given person.
     */
    public int numRescueBoats(List<Integer> people, int limit) {
        // Write your code here.
        people.sort((p1, p2) -> Integer.compare(p1, p2));
        int res = 0, i = 0, j = people.size() - 1;
        while (i < j) {
            if (people.get(i) + people.get(j) <= limit) {
                i++;
            }
            
            j--;
            res++;
        }
        
        return res + (i == j ? 1 : 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(Arrays.asList(1, 2), 3));
    }
}
