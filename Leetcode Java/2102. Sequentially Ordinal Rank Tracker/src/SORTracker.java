import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class SORTracker {
    private PriorityQueue<List> minHeap;
    private PriorityQueue<List> maxHeap;
    private int i;
    public SORTracker() {
        minHeap = new PriorityQueue<>((i1, i2) -> (int)i1.get(1) != (int)i2.get(1) ? (int)i1.get(1) - (int)i2.get(1) : ((String)i2.get(0)).compareTo((String)i1.get(0)));
        maxHeap = new PriorityQueue<>((i1, i2) -> (int)i1.get(1) != (int)i2.get(1) ? (int)i2.get(1) - (int)i1.get(1) : ((String)i1.get(0)).compareTo((String)i2.get(0)));
        i = 1;
    }

    public void add(String name, int score) {
        if (minHeap.isEmpty() || score > (int)minHeap.peek().get(1) || score == (int)minHeap.peek().get(1) && name.compareTo((String)minHeap.peek().get(0)) < 0) {
            minHeap.offer(Arrays.asList(name, score));
        }
        else {
            maxHeap.offer(Arrays.asList(name, score));
        }
        while (minHeap.size() > i) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public String get() {
        while (minHeap.size() < i) {
            minHeap.offer(maxHeap.poll());
        }
        i++;
        return (String)minHeap.peek().get(0);
    }

    public static void main(String[] args) {
        SORTracker tracker = new SORTracker(); // Initialize the tracker system.
        tracker.add("bradford", 2); // Add location with name="bradford" and score=2 to the system.
        tracker.add("branford", 3); // Add location with name="branford" and score=3 to the system.
        System.out.println(tracker.get());              // The sorted locations, from best to worst, are: branford, bradford.
        // Note that branford precedes bradford due to its higher score (3 > 2).
        // This is the 1st time get() is called, so return the best location: "branford".
        tracker.add("alps", 2);     // Add location with name="alps" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, alps, bradford.
        // Note that alps precedes bradford even though they have the same score (2).
        // This is because "alps" is lexicographically smaller than "bradford".
        // Return the 2nd best location "alps", as it is the 2nd time get() is called.
        tracker.add("orland", 2);   // Add location with name="orland" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, alps, bradford, orland.
        // Return "bradford", as it is the 3rd time get() is called.
        tracker.add("orlando", 3);  // Add location with name="orlando" and score=3 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alps, bradford, orland.
        // Return "bradford".
        tracker.add("alpine", 2);   // Add location with name="alpine" and score=2 to the system.
        System.out.println(tracker.get());              // Sorted locations: branford, orlando, alpine, alps, bradford, orland.
        // Return "bradford".
        System.out.println(tracker.get());
    }
}