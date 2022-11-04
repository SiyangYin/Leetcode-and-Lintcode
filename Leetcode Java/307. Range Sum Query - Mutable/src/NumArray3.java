public class NumArray3 {
    private int[] st;
    private int n;
    private int[] arr;
    public NumArray3(int[] nums) {
        arr = nums;
        n = nums.length;
        int x = (int)Math.ceil(Math.log(n) / Math.log(2));
        int max = (int)Math.pow(2, x) * 2 - 1;
        st = new int[max];
        build(nums, st, 0, n - 1, 0);
    }

    public void update(int index, int val) {
        if (index < 0 || index > n - 1) {
            return;
        }
        int diff = val - arr[index];
        arr[index] = val;
        update(0, n - 1, 0, index, diff);
    }

    public int sumRange(int left, int right) {
        if (left < 0 || right > n - 1 || right < left) {
            return -1;
        }
        return query(0, n - 1, left, right, 0);
    }

    public int build(int[] arr, int[] st, int ss, int se, int si) {
        if(ss == se) {
            st[si] = arr[ss];
            return st[si];
        }
        int mid = ss + se >> 1;
        st[si] = build(arr, st, ss, mid, 2 * si + 1) + build(arr, st, mid + 1, se, 2 * si + 2);
        return st[si];
    }

    public void update(int ss, int se, int si, int i, int diff) {
        if(i < ss || i > se) {
            return;
        }
        st[si] = st[si] + diff;
        if (ss != se) {
            int mid = ss + se >> 1;
            update(ss, mid, 2 * si + 1, i, diff);
            update(mid + 1, se, 2 * si + 2, i, diff);
        }
    }

    public int query(int ss, int se, int qs, int qe, int si) {
        if (ss >= qs && se <= qe) {
            return st[si];
        }
        else if (se < qs || ss > qe) {
            return 0;
        }
        int mid = ss + se >> 1;
        return query(ss, mid, qs, qe, 2 * si + 1) + query(mid + 1, se, qs, qe, 2 * si + 2);
    }
    
    public static void main(String[] args) {
        NumArray3 array = new NumArray3(new int[]{1, 3, 5});
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}
