import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param a: first sequence
     * @param b: second sequence
     * @return: return ans
     */
    public List<List<Integer>> Intersection(List<List<Integer>> a, List<List<Integer>> b) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (a.isEmpty() || b.isEmpty()) {
            return res;
        }
     
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (check(a.get(i), b.get(j))) {
                res.add(Arrays.asList(i, j));
                if (a.get(i).get(1) < b.get(j).get(1)) {
                    i++;
                } else if (a.get(i).get(1) > b.get(j).get(1)) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else {
                if (a.get(i).get(1) < b.get(j).get(0)) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        
        return res;
    }
    
    private boolean check(List<Integer> i1, List<Integer> i2) {
        return !(i1.get(1) < i2.get(0) || i2.get(1) < i1.get(0));
    }
    
    public static void main(String[] args) {
        List<List<Integer>> a = new ArrayList<>();
        a.add(Arrays.asList(994, 995));
        a.add(Arrays.asList(996, 997));
        a.add(Arrays.asList(999, 1000));
        
        List<List<Integer>> b = new ArrayList<>();
        b.add(Arrays.asList(993, 994));
        b.add(Arrays.asList(997, 998));
        b.add(Arrays.asList(999, 1000));
        System.out.println(new Solution().Intersection(a, b));
    }
}
