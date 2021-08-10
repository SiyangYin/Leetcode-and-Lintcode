public class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        int n = wordlist.length;
        int[][] f = new int[n][n];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 6; k++) {
                    if (wordlist[i].charAt(k) == wordlist[j].charAt(k)) {
                        f[i][j]++;
                    }
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            int k = -1, w = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (vis[j]) {
                    continue;
                }
                
                int t = 0;
                for (int u = 0; u <= 6; u++) {
                    t = Math.max(t, get(j, u, n, vis, f));
                }
                
                if (w > t) {
                    k = j;
                    w = t;
                }
            }
            
            int res = master.guess(wordlist[k]);
            if (res == 6) {
                break;
            }
            
            vis[k] = true;
            for (int j = 0; j < n; j++) {
                if (f[k][j] != res) {
                    vis[j] = true;
                }
            }
        }
    }
    
    int get(int j, int u, int n, boolean[] vis, int[][] f) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i] && f[j][i] == u) {
                res++;
            }
        }
        
        return res;
    }
}

interface Master {
    int guess(String word);
}