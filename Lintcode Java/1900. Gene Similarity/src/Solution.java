public class Solution {
    
    class Gene {
        char ch;
        int len;
        
        public Gene(char ch, int len) {
            this.ch = ch;
            this.len = len;
        }
    }
    
    /**
     * @param Gene1: a string
     * @param Gene2: a string
     * @return: return the similarity of two gene fragments
     */
    public String GeneSimilarity(String Gene1, String Gene2) {
        // write your code here
        int count = 0, totalLen = 0, idx1 = 0, idx2 = 0;
        Gene g1 = new Gene(' ', 0), g2 = new Gene(' ', 0);
        while (idx1 < Gene1.length() || idx2 < Gene2.length()) {
            if (g1.len == 0) {
                int i1 = idx1;
                while (i1 < Gene1.length() && Character.isDigit(Gene1.charAt(i1))) {
                    i1++;
                }
                
                g1 = new Gene(Gene1.charAt(i1), Integer.parseInt(Gene1.substring(idx1, i1)));
                totalLen += g1.len;
                idx1 = i1 + 1;
            }
            
            if (g2.len == 0) {
                int i2 = idx2;
                while (i2 < Gene2.length() && Character.isDigit(Gene2.charAt(i2))) {
                    i2++;
                }
                
                g2 = new Gene(Gene2.charAt(i2), Integer.parseInt(Gene2.substring(idx2, i2)));
                idx2 = i2 + 1;
            }
            
            count += getCount(g1, g2);
            
        }
        
        return count + "/" + totalLen;
    }
    
    private int getCount(Gene g1, Gene g2) {
        int l1 = g1.len, l2 = g2.len;
        g1.len = Math.max(l1 - l2, 0);
        g2.len = Math.max(l2 - l1, 0);
        
        return g1.ch == g2.ch ? Math.min(l1, l2) : 0;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().GeneSimilarity("2T3G", "3T2G"));
        // System.out.println(new Solution().GeneSimilarity("3T2G4A1C", "6T1A2C1G"));
        System.out.println(new Solution().GeneSimilarity("8C8G1C1A2C", "3G10C3T1C1A2C"));
    }
}
