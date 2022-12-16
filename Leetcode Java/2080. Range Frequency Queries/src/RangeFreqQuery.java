import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RangeFreqQuery {
    private Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.putIfAbsent(arr[i], list);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) {
            return 0;
        }
        else {
            List<Integer> list = map.get(value);
            int l1 = 0, r1 = list.size() - 1;
            while (l1 < r1) {
                int m = l1 + r1 >> 1;
                if (list.get(m) < left) {
                    l1 = m + 1;
                }
                else {
                    r1 = m;
                }
            }
            if (list.get(l1) < left) {
                l1++;
            }
            int l2 = 0, r2 = list.size() - 1;
            while (l2 < r2) {
                int m = l2 + r2 >> 1;
                if (list.get(m) < right) {
                    l2 = m + 1;
                }
                else {
                    r2 = m;
                }
            }
            if (list.get(l2) > right) {
                l2--;
            }
            return l2 - l1 + 1;
        }
    }

    public static void main(String[] args) {
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[] {12,33,4,56,22,2,34,33,22,12,34,56});
        System.out.println(rangeFreqQuery.query(1,2,4));
        System.out.println(rangeFreqQuery.query(0,11,33));
    }
}
