public class RangeModule {
    
    class SegTree {
        class Node {
            int l, r;
            boolean mark;
            int lazy;
            Node left, right;
            
            public Node(int l, int r) {
                this.l = l;
                this.r = r;
            }
        }
        
        private Node tr;
        
        public SegTree(int l, int r) {
            tr = new Node(l, r);
        }
        
        private void pushup(Node u) {
            u.mark = u.left.mark && u.right.mark;
        }
        
        private void pushdown(Node u) {
            if (u.lazy != 0) {
                u.left.mark = u.right.mark = u.lazy == 1;
                u.left.lazy = u.right.lazy = u.lazy;
                u.lazy = 0;
            }
        }
        
        public void split(Node u) {
            if (u.left != null && u.right != null) {
                return;
            }
            
            int m = u.l + (u.r - u.l >> 1);
            u.left = new Node(u.l, m);
            u.right = new Node(m + 1, u.r);
        }
        
        public void add(int l, int r) {
            add(tr, l, r);
        }
        
        private void add(Node u, int l, int r) {
            if (l <= u.l && u.r <= r) {
                u.mark = true;
                u.lazy = 1;
                return;
            }
            
            split(u);
            pushdown(u);
            int m = u.l + (u.r - u.l >> 1);
            if (l <= m) {
                add(u.left, l, r);
            }
            if (m + 1 <= r) {
                add(u.right, l, r);
            }
            pushup(u);
        }
        
        public void remove(int l, int r) {
            remove(tr, l, r);
        }
        
        private void remove(Node u, int l, int r) {
            if (l <= u.l && u.r <= r) {
                u.mark = false;
                u.lazy = -1;
                return;
            }
            
            split(u);
            pushdown(u);
            int m = u.l + (u.r - u.l >> 1);
            if (l <= m) {
                remove(u.left, l, r);
            }
            if (m + 1 <= r) {
                remove(u.right, l, r);
            }
            pushup(u);
        }
        
        public boolean query(int l, int r) {
            return query(tr, l, r);
        }
        
        private boolean query(Node u, int l, int r) {
            if (l <= u.l && u.r <= r) {
                return u.mark;
            }
            
            split(u);
            pushdown(u);
            int m = u.l + (u.r - u.l >> 1);
            if (l <= m && !query(u.left, l, r)){
                return false;
            }
            
            if (m + 1 <= r && !query(u.right, l, r)) {
                return false;
            }
            
            return true;
        }
    }
    
    final int N = (int) 1e9;
    
    private SegTree segTree;
    
    public RangeModule() {
        segTree = new SegTree(1, N);
    }
    
    public void addRange(int left, int right) {
        segTree.add(left, right - 1);
    }
    
    public boolean queryRange(int left, int right) {
        return segTree.query(left, right - 1);
    }
    
    public void removeRange(int left, int right) {
        segTree.remove(left, right - 1);
    }
    
    public static void main(String[] args) {
        RangeModule ran = new RangeModule();
        ran.addRange(10, 20);
        ran.removeRange(14, 16);
        System.out.println(ran.queryRange(10, 14));
        System.out.println(ran.queryRange(13, 15));
        System.out.println(ran.queryRange(16, 17));
    }
}