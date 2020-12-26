import java.util.*;

public class LoadBalancer {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;
    
    public LoadBalancer() {
        // do intialization if necessary
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /*
     * @param server_id: add a new server to the cluster
     * @return: nothing
     */
    public void add(int server_id) {
        // write your code here
        list.add(server_id);
        map.put(server_id, list.size() - 1);
    }
    
    /*
     * @param server_id: server_id remove a bad server from the cluster
     * @return: nothing
     */
    public void remove(int server_id) {
        // write your code here
        int idx = map.get(server_id);
        Collections.swap(list, idx, list.size() - 1);
        map.put(list.get(idx), idx);
        
        list.remove(list.size() - 1);
        map.remove(server_id);
    }
    
    /*
     * @return: pick a server in the cluster randomly with equal probability
     */
    public int pick() {
        // write your code here
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
