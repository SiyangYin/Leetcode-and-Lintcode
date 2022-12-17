import java.util.HashMap;
import java.util.Map;

class AuthenticationManager {
    private Map<String, Integer> map;
    private int ttl;
    public AuthenticationManager(int timeToLive) {
        map = new HashMap<>();
        ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime) {
            map.put(tokenId, currentTime + ttl);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int cnt = 0;
        for (int i : map.values()) {
            if (i > currentTime) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa",1);
        authenticationManager.generate("aaa",2);
        System.out.println(authenticationManager.countUnexpiredTokens(6));
        authenticationManager.generate("bbb",7);
        authenticationManager.renew("aaa",8);
        authenticationManager.renew("bbb",10);
        System.out.println(authenticationManager.countUnexpiredTokens(15));

    }
}
