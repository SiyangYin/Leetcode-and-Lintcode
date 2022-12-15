public class RLEIterator {
    private int[] arr;
    private int i = 0;
    public RLEIterator(int[] encoding) {
        arr = encoding;
    }

    public int next(int n) {
        while (i < arr.length - 2 && arr[i] < n) {
            n -= arr[i];
            i += 2;
        }
        if (arr[i] >= n) {
            arr[i] -= n;
            return arr[i + 1];
        }
        else {
            arr[i] = 0;
            return -1;
        }
    }

    public static void main(String[] args) {
        RLEIterator rleIterator = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));
    }
}
