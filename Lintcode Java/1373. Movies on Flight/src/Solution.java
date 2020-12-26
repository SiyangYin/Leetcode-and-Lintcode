import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param arr: An integer array
     * @param k: An integer
     * @return: return the pair of movies index with the longest total duration
     */
    public int[] FlightDetails(int[] arr, int k) {
        // write your code here
        int[] res = new int[2];
        k -= 30;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        Arrays.sort(arr);
        
        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] > k) {
                r--;
            } else {
                if (arr[l] + arr[r] > res[0] + res[1]) {
                    res[0] = arr[l];
                    res[1] = arr[r];
                }
                
                l++;
            }
        }
        
        res[0] = map.get(res[0]);
        res[1] = map.get(res[1]);
        if (res[0] > res[1]) {
            int tmp = res[0];
            res[0] = res[1];
            res[1] = tmp;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().FlightDetails(new int[]{222, 182, 274, 341, 417, 48, 350, 9, 110, 34, 292, 142}, 192)));
    }
}
