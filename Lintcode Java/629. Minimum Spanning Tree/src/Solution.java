import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    class UnionFind {
        private Map<String, String> parent;
    
        public UnionFind(List<Connection> list) {
            parent = new HashMap<>();
            for (Connection connection : list) {
                parent.putIfAbsent(connection.city1, connection.city1);
                parent.putIfAbsent(connection.city2, connection.city2);
            }
        }
        
        private String  find(String s) {
            if (!s.equals(parent.get(s))) {
                parent.put(s, find(parent.get(s)));
            }
            
            return parent.get(s);
        }
        
        public boolean union(String s1, String s2) {
            String p1 = find(s1), p2 = find(s2);
            if (p1.equals(p2)) {
                return false;
            }
            
            parent.put(p1, p2);
            return true;
        }
        
        public int size() {
            return parent.size();
        }
    }
    
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        connections.sort((c1, c2) -> c1.cost != c2.cost ? Integer.compare(c1.cost, c2.cost) : !c1.city1.equals(c2.city1) ? c1.city1.compareTo(c2.city1) : c1.city2.compareTo(c2.city2));
        List<Connection> res = new ArrayList<>();
    
        UnionFind uf = new UnionFind(connections);
        for (Connection connection : connections) {
            String city1 = connection.city1, city2 = connection.city2;
            if (uf.union(city1, city2)) {
                res.add(connection);
            }
            
            if (res.size() == uf.size() - 1) {
                return res;
            }
        }
        
        return new ArrayList<>();
    }
    
    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>();
        connections.add(new Connection("Acity", "Bcity", 1));
        connections.add(new Connection("Bcity", "Ccity", 2));
        connections.add(new Connection("Acity", "Ccity", 2));
        System.out.println(new Solution().lowestCost(connections));
    }
}

class Connection {
    public String city1, city2;
    public int cost;
    
    public Connection(String city1, String city2, int cost) {
        this.city1 = city1;
        this.city2 = city2;
        this.cost = cost;
    }
    
    @Override
    public String toString() {
        return "Connection{" +
                "city1='" + city1 + '\'' +
                ", city2='" + city2 + '\'' +
                ", cost=" + cost +
                '}';
    }
}