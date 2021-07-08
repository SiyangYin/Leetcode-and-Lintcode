import java.util.TreeSet;

public class ExamRoom {
    
    private int n;
    private TreeSet<Integer> treeSet;
    
    public ExamRoom(int N) {
        n = N;
        treeSet = new TreeSet<>();
    }
    
    public int seat() {
        if (treeSet.isEmpty()) {
            treeSet.add(0);
            return 0;
        }
        
        int res = 0, prev = 0, diff = treeSet.first();
        for (int x : treeSet) {
            int pos = prev + x >> 1;
            if (pos - prev > diff) {
                diff = pos - prev;
                res = pos;
            }
            
            prev = x;
        }
        
        if (n - 1 - prev > diff) {
            res = n - 1;
        }
        
        treeSet.add(res);
        return res;
    }
    
    public void leave(int p) {
        treeSet.remove(p);
    }
    
    public static void main(String[] args) {
        ExamRoom room = new ExamRoom(10);
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        System.out.println(room.seat());
        room.leave(4);
        System.out.println(room.seat());
    }
}