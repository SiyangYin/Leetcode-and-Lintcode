import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationIterator {
    private List<String> list;
    private int i;
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        i = 0;
        dfs(characters, combinationLength, 0, new StringBuilder(), list);
    }

    public String next() {
        return list.get(i++);
    }

    public boolean hasNext() {
        return i < list.size();
    }

    public void dfs(String s, int n, int start, StringBuilder sb, List<String> list) {
        if (sb.length() == n) {
            list.add(sb.toString());
        }
        else {
            for (int i = start; i < s.length(); i++) {
                sb.append(s.charAt(i));
                dfs(s, n, i + 1, sb, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationIterator combinationIterator = new CombinationIterator("abc", 2);
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
        System.out.println(combinationIterator.next());
        System.out.println(combinationIterator.hasNext());
    }
}

