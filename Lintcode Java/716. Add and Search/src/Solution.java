import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param inputs: an integer array
     * @param tests: an integer array
     * @return: return true if sum of two values in inputs are in tests.
     */
    public boolean addAndSearch(int[] inputs, int[] tests) {
        // write your code here.
        Set<Integer> set = new HashSet<>();
        for (int x : tests) {
            set.add(x);
        }
    
        for (int i = 0; i < inputs.length - 1; i++) {
            for (int j = i + 1; j < inputs.length; j++) {
                if (set.contains(inputs[i] + inputs[j])) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
