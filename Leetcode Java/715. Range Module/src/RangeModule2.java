import java.util.Iterator;
import java.util.TreeSet;

public class RangeModule2 {
    
    private TreeSet<int[]> treeSet;
    
    public RangeModule2() {
        treeSet = new TreeSet<>((a, b) -> Integer.compare(a[1], b[1]));
    }
    
    public void addRange(int left, int right) {
        Iterator<int[]> iter = treeSet.tailSet(new int[]{0, left}, true).iterator();
        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] > right) {
                break;
            }
            
            left = Math.min(left, temp[0]);
            right = Math.max(right, temp[1]);
            iter.remove();
        }
        
        treeSet.add(new int[]{left, right});
    }
    
    public boolean queryRange(int left, int right) {
        int[] ceiling = treeSet.ceiling(new int[]{0, right});
        return ceiling != null && ceiling[0] <= left;
    }
    
    public void removeRange(int left, int right) {
        Iterator<int[]> iter = treeSet.tailSet(new int[]{0, left}, false).iterator();
        
        int[] prev = null, next = null;
        
        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] >= right) {
                break;
            }
            
            if (temp[0] < left) {
                prev = new int[]{temp[0], left};
            }
            if (right < temp[1]) {
                next = new int[]{right, temp[1]};
            }
            iter.remove();
        }
        
        if (prev != null) {
            treeSet.add(prev);
        }
        if (next != null) {
            treeSet.add(next);
        }
    }
    
    public static void main(String[] args) {
        RangeModule2 ran = new RangeModule2();
        ran.addRange(10, 20);
        ran.removeRange(14, 16);
        System.out.println(ran.queryRange(10, 14));
        System.out.println(ran.queryRange(13, 15));
        System.out.println(ran.queryRange(16, 17));
        
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
    
        System.out.println("haha");
        for (Integer x : set.tailSet(2, false)) {
            System.out.println(x);
        }
    }
}
