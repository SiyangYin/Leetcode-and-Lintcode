import java.util.*;

class Allocator {
    private int[] arr;
    private Map<Integer, List<int[]>> map;
    public Allocator(int n) {
        arr = new int[n];
        map = new HashMap<>();
    }

    public int allocate(int size, int mID) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 0) {
                int start = i;
                int cnt = 0;
                while (i < arr.length && arr[i] == 0) {
                    i++;
                    cnt++;
                    if (cnt == size) {
                        Arrays.fill(arr, start, start + size, mID);
                        List<int[]> list = map.getOrDefault(mID, new ArrayList<>());
                        list.add(new int[]{start, start + size});
                        map.putIfAbsent(mID, list);
                        return start;
                    }
                }
            }
            i++;
        }
        return -1;
    }

    public int free(int mID) {
        if (map.containsKey(mID)) {
            int cnt = 0;
            List<int[]> list = map.get(mID);
            for (int[] i : list) {
                Arrays.fill(arr, i[0], i[1], 0);
                cnt += i[1] - i[0];
            }
            list.clear();
            return cnt;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Allocator allocator = new Allocator(10);
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1, 2));
        System.out.println(allocator.allocate(1, 3));
        System.out.println(allocator.free(2));
        System.out.println(allocator.allocate(3, 4));
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.allocate(1, 1));
        System.out.println(allocator.free(1));
        System.out.println(allocator.allocate(10, 2));
        System.out.println(allocator.free(7));
    }
}