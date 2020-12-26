import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        private Map<Integer, Integer> parent;
        
        public UnionFind(List<DirectedGraphNode> nodes) {
            parent = new HashMap<>();
            for (DirectedGraphNode node : nodes) {
                parent.putIfAbsent(node.label, node.label);
                for (DirectedGraphNode neighbor : node.neighbors) {
                    parent.putIfAbsent(neighbor.label, neighbor.label);
                }
            }
        }
        
        private int find(int x) {
            int p = parent.get(x);
            if (x != p) {
                parent.put(x, find(p));
            }
            
            return parent.get(x);
        }
        
        public void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px != py) {
                parent.put(px, py);
            }
        }
        
        public List<Integer> getRoots() {
            List<Integer> res = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : parent.entrySet()) {
                if (entry.getKey().equals(entry.getValue())) {
                    res.add(entry.getKey());
                }
            }
            return res;
        }
    }
    
    /*
     * @param nodes: a array of Directed graph node
     * @return: a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(List<DirectedGraphNode> nodes) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        UnionFind uf = new UnionFind(nodes);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int root : uf.getRoots()) {
            groups.put(root, new ArrayList<>());
        }
        
        for (DirectedGraphNode node : nodes) {
            int root = uf.find(node.label);
            groups.get(root).add(node.label);
        }
    
        for (List<Integer> list : groups.values()) {
            list.sort(Integer::compareTo);
            res.add(list);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        List<DirectedGraphNode> nodes = new ArrayList<>();
        nodes.add(new DirectedGraphNode(1));
        nodes.add(new DirectedGraphNode(2));
        nodes.add(new DirectedGraphNode(3));
        nodes.add(new DirectedGraphNode(4));
        nodes.add(new DirectedGraphNode(5));
        nodes.add(new DirectedGraphNode(6));
        
        nodes.get(0).neighbors.add(nodes.get(1));
        nodes.get(0).neighbors.add(nodes.get(3));
        nodes.get(2).neighbors.add(nodes.get(4));
        nodes.get(5).neighbors.add(nodes.get(4));
    
        System.out.println(new Solution().connectedSet2(nodes));
    }
}

class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    
    public DirectedGraphNode(int label) {
        this.label = label;
        neighbors = new ArrayList<>();
    }
}