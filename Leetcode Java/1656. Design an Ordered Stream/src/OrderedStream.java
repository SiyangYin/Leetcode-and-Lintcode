import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStream {
    private List<String> list;
    private int p;
    public OrderedStream(int n) {
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(null);
        }
        p = 0;
    }

    public List<String> insert(int idKey, String value) {
        list.add(idKey - 1, value);
        list.remove(idKey);
        List<String> res = new ArrayList<>();
        while (p < list.size() && list.get(p) != null) {
            res.add(list.get(p));
            p++;
        }
        return res;
    }

    public static void main(String[] args) {
        // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc")); // Inserts (3, "ccccc"), returns [].
        System.out.println(os.insert(1, "aaaaa")); // Inserts (1, "aaaaa"), returns ["aaaaa"].
        System.out.println(os.insert(2, "bbbbb")); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
        System.out.println(os.insert(5, "eeeee")); // Inserts (5, "eeeee"), returns [].
        System.out.println(os.insert(4, "ddddd")); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
// Concatentating all the chunks returned:
// [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
// The resulting order is the same as the order above.
    }
}
