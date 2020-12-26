import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class SegmentTree {
        private int[] tree;
        private int n;
    
        public SegmentTree(int[] A) {
            n = A.length;
            tree = new int[4 * A.length];
            for (int i = 0; i < A.length; i++) {
                update(i, A[i]);
            }
        }
    
        private void update(int idx, int val) {
            update(0, 0, n - 1, idx, val);
        }
        
        private void update(int treeIdx, int l, int r, int idx, int val) {
            if (l == r) {
                tree[treeIdx] = val;
                return;
            }
            
            int m = l + (r - l >> 1);
            if (idx <= m) {
                update(leftChild(treeIdx), l, m, idx, val);
            } else {
                update(rightChild(treeIdx), m + 1, r, idx, val);
            }
            
            tree[treeIdx] = Math.min(tree[leftChild(treeIdx)], tree[rightChild(treeIdx)]);
        }
        
        public int queryMin(int qL, int qR) {
            return queryMin(0, 0, n - 1, qL, qR);
        }
        
        private int queryMin(int treeIdx, int l, int r, int qL, int qR) {
            if (l == qL && r == qR) {
                return tree[treeIdx];
            }
            
            int m = l + (r - l >> 1);
            if (qL >= m + 1) {
                return queryMin(rightChild(treeIdx), m + 1, r, qL, qR);
            } else if (qR <= m) {
                return queryMin(leftChild(treeIdx), l, m, qL, qR);
            }
            
            return Math.min(queryMin(leftChild(treeIdx), l, m, qL, m), queryMin(rightChild(treeIdx), m + 1, r, m + 1, qR));
        }
        
        private int leftChild(int treeIdx) {
            return 2 * treeIdx + 1;
        }
        
        private int rightChild(int treeIdx) {
            return 2 * treeIdx + 2;
        }
    }
    
    /**
     * @param A: An integer array
     * @param queries: An query list
     * @return: The result list
     */
    public List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        SegmentTree segTree = new SegmentTree(A);
    
        for (Interval query : queries) {
            res.add(segTree.queryMin(query.start, query.end));
        }
        
        return res;
    }
}

class Interval {
    int start, end;
    
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}