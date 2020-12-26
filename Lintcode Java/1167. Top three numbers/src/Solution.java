import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    /**
     * @param arr: An array
     * @return: Get the three largest numbers in the array
     */
    public List<Integer> TopThree(List<Integer> arr) {
        // write your code here
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : arr) {
            if (set.size() < 3) {
                set.add(n);
            } else {
                if (n > set.first()) {
                    set.add(n);
                    if (set.size() > 3) {
                        set.remove(set.first());
                    }
                }
            }
        }
        
        List<Integer> res = new ArrayList<>(set);
        Collections.reverse(res);
        return res;
    }
}
