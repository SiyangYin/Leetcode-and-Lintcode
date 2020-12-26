import java.util.*;

public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return arr1;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
    
        List<Integer> arr = new ArrayList<>(arr1.length);
        for (int n : arr1) {
            arr.add(n);
        }
        
        arr.sort((i1, i2) -> {
            Integer p1 = map.get(i1), p2 = map.get(i2);
            if (p1 == null && p2 == null) {
                return Integer.compare(i1, i2);
            } else if (p1 == null) {
                return 1;
            } else if (p2 == null) {
                return -1;
            } else {
                return Integer.compare(p1, p2);
            }
        });
    
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr.get(i);
        }
        
        return arr1;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(new Solution().relativeSortArray(arr1, arr2)));
    }
}
