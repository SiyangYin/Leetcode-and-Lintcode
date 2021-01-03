import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /*
     * Complete the 'routePairs' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER maxTravelDist
     *  2. 2D_INTEGER_ARRAY forwardRouteList
     *  3. 2D_INTEGER_ARRAY returnRouteList
     */
    
    public static List<List<Integer>> routePairs(int maxTravelDist, List<List<Integer>> f, List<List<Integer>> r) {
        // Write your code here
        f.sort((l1, l2) -> Integer.compare(l1.get(1), l2.get(1)));
        r.sort((l1, l2) -> Integer.compare(l1.get(1), l2.get(1)));
        
        List<List<Integer>> res = new ArrayList<>();
        int maxSum = 0;
        
        for (int i = 0; i < f.size(); i++) {
            int idx = binarySearch(r, f.get(i).get(1), maxTravelDist);
            if (idx == -1) {
                break;
            }
            
            if (f.get(i).get(1) + r.get(idx).get(1) < maxSum) {
                continue;
            } else if (f.get(i).get(1) + r.get(idx).get(1) == maxSum) {
                int val = r.get(idx).get(1), ii = idx;
                while (ii >= 0 && r.get(ii).get(1) == val) {
                    res.add(Arrays.asList(f.get(i).get(0), r.get(ii).get(0)));
                    ii--;
                }
            } else {
                res.clear();
                int val = r.get(idx).get(1), ii = idx;
                while (ii >= 0 && r.get(ii).get(1) == val) {
                    res.add(Arrays.asList(f.get(i).get(0), r.get(ii).get(0)));
                    ii--;
                }
    
                maxSum = f.get(i).get(1) + r.get(idx).get(1);
            }
        }
        
        return res;
    }
    
    private static int binarySearch(List<List<Integer>> f, int first, int maxDist) {
        int l = 0, r = f.size() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            int sum = f.get(m).get(1) + first;
            if (sum <= maxDist) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return f.get(l).get(1) + first <= maxDist ? l : -1;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> f = new ArrayList<>(), r = new ArrayList<>();
        f.add(Arrays.asList(1, 2000));
        f.add(Arrays.asList(2, 5000));
        f.add(Arrays.asList(3, 7000));
        f.add(Arrays.asList(4, 10000));
        
        r.add(Arrays.asList(1, 2000));
        r.add(Arrays.asList(2, 3000));
        r.add(Arrays.asList(3, 4000));
        r.add(Arrays.asList(4, 5000));
    
        System.out.println(routePairs(10000, f, r));
    }
}