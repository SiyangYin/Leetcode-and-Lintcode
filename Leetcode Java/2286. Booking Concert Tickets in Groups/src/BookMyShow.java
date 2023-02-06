import java.util.Arrays;

class BookMyShow {
    private int m;
    private int start;
    private int[] arr;
    public BookMyShow(int n, int m) {
        this.m = m;
        start = 0;
        arr = new int[n];
    }

    public int[] gather(int k, int maxRow) {
        for (int i = start; i <= maxRow; i++) {
            if (arr[i] + k <= m) {
                arr[i] += k;
                return new int[]{i, arr[i] - k};
            }
        }
        return new int[0];
    }

    public boolean scatter(int k, int maxRow) {
        if ((maxRow - start + 1) * (long)m < k) {
            return false;
        }
        long sum = 0;
        int end = 0;
        for (int i = start; i <= maxRow; i++) {
            sum += m - arr[i];
            if (sum >= k) {
                end = i;
                break;
            }
        }
        if (sum < k) {
            return false;
        }
        arr[end] = m - (int)(sum - k);
        start = sum == k ? end + 1 : end;
        return true;
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow(2, 5);
        Arrays.stream(bookMyShow.gather(4, 0)).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        Arrays.stream(bookMyShow.gather(2, 0)).forEach(i -> System.out.print(i + ", "));
        System.out.println();
        System.out.println(bookMyShow.scatter(5, 1));
        System.out.println(bookMyShow.scatter(5, 1));
    }
}