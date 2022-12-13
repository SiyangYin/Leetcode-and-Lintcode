import java.util.*;

class SummaryRanges {
    Set<Integer> set1;
    Set<Integer> set2;
    public SummaryRanges() {
        set1 = new TreeSet<>();
        set2 = new TreeSet<>();
    }

    public void addNum(int value) {
        if (!set1.contains(value) && !set2.contains(value)) {
            if (set1.contains(value + 1) && set2.contains(value - 1)) {
                set1.remove(value + 1);
                set2.remove(value - 1);
            }
            else if (set1.contains(value + 1)) {
                set1.remove(value + 1);
                set1.add(value);
            }
            else if (set2.contains(value - 1)) {
                set2.remove(value - 1);
                set2.add(value);
            }
            else {
                List<Integer> list1 = new ArrayList<>(set1);
                List<Integer> list2 = new ArrayList<>(set2);
                int l = 0, r = list1.size() - 1;
                while (l < r) {
                    int m = l + r >> 1;
                    if (list1.get(m) < value) {
                        l = m + 1;
                    }
                    else {
                        r = m - 1;
                    }
                }
                if (list2.isEmpty()
                        || list1.get(l) < value && list2.get(l) < value
                        || list1.get(l) > value && l == 0
                        || list1.get(l) > value && list1.get(l - 1) < value && list2.get(l - 1) < value) {
                    set1.add(value);
                    set2.add(value);
                }
            }
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[set1.size()][2];
        int i = 0;
        Iterator i1 = set1.iterator();
        Iterator i2 = set2.iterator();
        while (i1.hasNext()) {
            res[i][0] = (int)i1.next();
            res[i][1] = (int)i2.next();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(6);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(6);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(0);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(4);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(8);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(7);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(6);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(4);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(7);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
        summaryRanges.addNum(5);
        Arrays.stream(summaryRanges.getIntervals()).forEach(i -> System.out.print("[" + i[0] + ", " + i[1] + "] "));
        System.out.println();
    }

}