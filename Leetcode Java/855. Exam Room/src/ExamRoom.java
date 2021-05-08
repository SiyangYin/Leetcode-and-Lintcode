import java.util.TreeSet;

public class ExamRoom {
    
    private TreeSet<Integer> seat;
    private int n;
    
    public ExamRoom(int N) {
        n = N;
        seat = new TreeSet<>();
    }
    
    public int seat() {
        if (seat.isEmpty()) {
            seat.add(0);
            return 0;
        }
        
        int left = -1, pos = 0, dist = seat.first();
        
        for (int x : seat) {
            if (left == -1) {
                left = x;
                continue;
            }
            
            if (dist < x - left >> 1) {
                dist = x - left >> 1;
                pos = left + dist;
            }
            
            left = x;
        }
        
        if (dist < n - 1 - seat.last()) {
            pos = n - 1;
        }
        
        seat.add(pos);
        return pos;
    }
    
    public void leave(int p) {
        seat.remove(p);
    }
    
    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(4);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(1);
        examRoom.leave(3);
        System.out.println(examRoom.seat());
    }
}