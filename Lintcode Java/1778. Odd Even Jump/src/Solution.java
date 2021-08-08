import java.util.*;

public class Solution {
    /**
     * @param A: An integer array A
     * @return: Return the number of good starting indexes
     */
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        List<Integer> id = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            id.add(i);
        }
        
        id.sort((x, y) -> -Integer.compare(A[x], A[y]));
        int[] floor = compute(id);
        process(id, A);
        int[] ceil = compute(id);
        
        int res = 1;
        boolean[][] f = new boolean[n][2];
        f[n - 1][0] = f[n - 1][1] = true;
        for (int i = n - 2; i >= 0; i--) {
            if (floor[i] != -1) {
                f[i][0] = f[floor[i]][1];
            }
            if (ceil[i] != -1) {
                f[i][1] = f[ceil[i]][0];
            }
            
            if (f[i][1]) {
                res++;
            }
        }
        
        return res;
    }
    
    void process(List<Integer> list, int[] A) {
        reverse(list, 0, list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            int j = i;
            while (j < list.size() && A[list.get(j)] == A[list.get(i)]) {
                j++;
            }
            
            reverse(list, i, j - 1);
            i = j - 1;
        }
    }
    
    void reverse(List<Integer> list, int l, int r) {
        for (; l < r; l++, r--) {
            Collections.swap(list, l, r);
        }
    }
    
    int[] compute(List<Integer> id) {
        int[] res = new int[id.size()];
        Arrays.fill(res, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < id.size(); i++) {
            while (!stk.isEmpty() && stk.peek() < id.get(i)) {
                res[stk.pop()] = id.get(i);
            }
            
            stk.push(id.get(i));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().oddEvenJumps(new int[]{0, 3, 2, 4, 5}));
        System.out.println(new Solution().oddEvenJumps(new int[]{2, 3, 1, 1, 4}));
    }
}
