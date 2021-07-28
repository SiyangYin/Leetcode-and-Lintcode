import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {
    
    private List<int[]>[] lists;
    private int snap;
    
    public SnapshotArray(int length) {
        lists = new ArrayList[length];
        for (int i = 0; i < length; i++) {
            lists[i] = new ArrayList<>();
            lists[i].add(new int[]{-1, 0});
        }
    }
    
    public void set(int index, int val) {
        lists[index].add(new int[]{snap, val});
    }
    
    public int snap() {
        return snap++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = this.lists[index];
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (list.get(m)[0] <= snap_id) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return list.get(l)[1];
    }
}
