import java.util.*;

public class MiniCassandra {
    
    private Map<String, Map<Integer, String>> map;
    
    public MiniCassandra() {
        // do intialization if necessary
        map = new HashMap<>();
    }
    
    /*
     * @param raw_key: a string
     * @param column_key: An integer
     * @param column_value: a string
     * @return: nothing
     */
    public void insert(String row_key, int column_key, String value) {
        // write your code here
        map.putIfAbsent(row_key, new TreeMap<>());
        map.get(row_key).put(column_key, value);
    }
    
    /*
     * @param row_key: a string
     * @param column_start: An integer
     * @param column_end: An integer
     * @return: a list of Columns
     */
    public List<Column> query(String row_key, int column_start, int column_end) {
        // write your code here
        List<Column> res = new ArrayList<>();
        if (map.containsKey(row_key)) {
            for (Map.Entry<Integer, String> entry : map.get(row_key).entrySet()) {
                if (column_start <= entry.getKey() && entry.getKey() <= column_end) {
                    res.add(new Column(entry.getKey(), entry.getValue()));
                }
            }
        }
        return res;
    }
}

class Column {
    public int key;
    public String value;
    
    public Column(int key, String value) {
        this.key = key;
        this.value = value;
    }
}