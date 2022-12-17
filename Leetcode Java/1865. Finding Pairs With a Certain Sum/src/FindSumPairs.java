import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private Map<Integer, Integer> map;
    private int[] nums1;
    private int[] nums2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        map = new HashMap<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    public void add(int index, int val) {
        map.put(nums2[index], map.get(nums2[index]) - 1);
        map.put(nums2[index] + val, map.getOrDefault(nums2[index] + val, 0) + 1);
        nums2[index] += val;
    }

    public int count(int tot) {
        int res = 0;
        for (int i : nums1) {
            if (map.containsKey(tot - i)) {
                res += map.get(tot - i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(new int[]{1,1,2,2,2,3}, new int[]{1,4,5,2,5,4});
        System.out.println(findSumPairs.count(7));
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8));
        System.out.println(findSumPairs.count(4));
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7));
    }
}
