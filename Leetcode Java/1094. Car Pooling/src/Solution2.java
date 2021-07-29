public class Solution2 {
    
    class BlockArray {
        private int len;
        private int[] A, max, lazy;
        
        public BlockArray(int size) {
            A = new int[size];
            len = (int) Math.sqrt(size);
            max = new int[size % len == 0 ? size / len : size / len + 1];
            lazy = new int[size % len == 0 ? size / len : size / len + 1];
        }
        
        private int get(int idx) {
            return idx / len;
        }
        
        public void add(int l, int r, int x) {
            if (get(l) == get(r)) {
                for (int k = l; k <= r; k++) {
                    A[k] += x;
                    max[get(k)] = Math.max(max[get(k)], A[k] + lazy[get(k)]);
                }
            } else {
                int i = l, j = r;
                while (get(i) == get(l)) {
                    A[i] += x;
                    max[get(i)] = Math.max(max[get(i)], A[i] + lazy[get(i)]);
                    i++;
                }
                while (get(j) == get(r)) {
                    A[j] += x;
                    max[get(j)] = Math.max(max[get(j)], A[j] + lazy[get(j)]);
                    j--;
                }
                
                for (int k = get(i); k <= get(j); k++) {
                    max[k] += x;
                    lazy[k] += x;
                }
            }
        }
        
        public int query(int l, int r) {
            int res = 0;
            if (get(l) == get(r)) {
                for (int k = l; k <= r; k++) {
                    res = Math.max(res, A[k] + lazy[get(k)]);
                }
            } else {
                int i = l, j = r;
                while (get(i) == get(l)) {
                    res = Math.max(res, A[i] + lazy[get(i)]);
                    i++;
                }
                while (get(j) == get(r)) {
                    res = Math.max(res, A[j] + lazy[get(j)]);
                    j--;
                }
                
                for (int k = get(i); k <= get(j); k++) {
                    res = Math.max(res, max[k]);
                }
            }
            
            return res;
        }
    }
    
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(max, trip[2]);
        }
        
        BlockArray A = new BlockArray(max);
        for (int[] trip : trips) {
            A.add(trip[1], trip[2] - 1, trip[0]);
        }
        
        return A.query(0, max - 1) <= capacity;
    }
    
    public static void main(String[] args) {
        int[][] t = {{9, 3, 6}, {8, 1, 7}, {6,6,8},{8,4,9},{4,2,9}};
        System.out.println(new Solution2().carPooling(t, 28));
    }
}
