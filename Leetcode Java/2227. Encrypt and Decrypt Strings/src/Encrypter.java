import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Encrypter {
    private Map<Character, String> map1;
    private Map<String, List<Character>> map2;
    private Map<String, Integer> map3;
    private boolean notPresent;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        map3 = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            map1.put(keys[i], values[i]);
            List<Character> list = map2.getOrDefault(values[i], new ArrayList<>());
            list.add(keys[i]);
            map2.putIfAbsent(values[i], list);
        }
        for (String s : dictionary) {
            notPresent = false;
            String s1 = encrypt(s);
            if (!notPresent) {
                map3.put(s1, map3.getOrDefault(s1, 0) + 1);
            }
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word1.length(); i++) {
            if (map1.containsKey(word1.charAt(i))) {
                sb.append(map1.get(word1.charAt(i)));
            }
            else {
                notPresent = true;
                sb.append("");
            }
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return map3.containsKey(word2) ? map3.get(word2) : 0;
    }

    public static void main(String[] args) {
        Encrypter encrypter = new Encrypter(new char[]{'a','b','c','d'}, new String[]{"ei","zf","ei","am"}, new String[]{"abcd","acbd","adbc","badc","dacb","cadb","cbda","abad"});
        System.out.println(encrypter.encrypt("abcd"));
        System.out.println(encrypter.decrypt("eizfeiam"));
    }
}
