import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 0; i < n - 1; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                list.add(list.get(size - 1 - j) + (1 << i + 1));
            }
        }
        
        int idx = 0;
        while (list.get(idx) != start) {
            idx++;
        }
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            res.add(list.get(idx + i < list.size() ? idx + i : idx + i - list.size()));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().circularPermutation(3, 2));
    }
}
