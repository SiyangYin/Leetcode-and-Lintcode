import java.util.PriorityQueue;
import java.util.TreeSet;

class LUPrefix1 {
    private TreeSet<Integer> set;
    private int i;
    public LUPrefix1(int n) {
        set = new TreeSet<>();
        i = 0;
    }

    public void upload(int video) {
        set.add(video);
    }

    public int longest() {
        while (set.contains(i + 1)) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        LUPrefix1 luPrefix = new LUPrefix1(4);
        luPrefix.upload(3);
        System.out.println(luPrefix.longest());
        luPrefix.upload(1);
        System.out.println(luPrefix.longest());
        luPrefix.upload(2);
        System.out.println(luPrefix.longest());
    }
}