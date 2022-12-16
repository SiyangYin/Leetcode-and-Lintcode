import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnapshotArray1 {
    private List<Map<Integer, Integer>> list;
    private Map<Integer, Integer> map;
    public SnapshotArray1(int length) {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public void set(int index, int val) {
        map.put(index, val);
    }

    public int snap() {
        list.add(new HashMap<>(map));
        map.clear();
        return list.size() - 1;
    }

    public int get(int index, int snap_id) {
        while (snap_id >= 0 && !list.get(snap_id).containsKey(index)) {
            snap_id--;
        }
        return snap_id >= 0 ? list.get(snap_id).get(index) : 0;
    }

    public static void main(String[] args) {
        SnapshotArray1 snapshotArray1 = new SnapshotArray1(3);
        snapshotArray1.set(0, 5);
        System.out.println(snapshotArray1.snap());
        snapshotArray1.set(0, 6);
        System.out.println(snapshotArray1.get(0, 0));
    }
}
